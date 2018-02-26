+function(win,$) {	
var weekName = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
var period = ["AM","PM","EM"];
/**班级、教师、课程*/
var attrib = ["CG","TC","CS"];
var urls = ["/CourseTimetable/service/classList",
	"/CourseTimetable/service/teacherList",
	"/CourseTimetable/service/courseList"
	];

/*var init_index = 0;
function XY(){
	var x_y = {
		x:Math.floor(init_index/9),
		y:init_index%9
	};
	init_index++;
	return x_y;
}*/
function printWeeks(data){
	var ary = data.classTime4day;
	var len = ary.length;
	var html = "";
	for(var i=0;i<len;i++){
		html += printDay(ary[i]);
	}
	return html;
}
function printDay(data){
	var ary = data.classRooms;
	var len = ary.length;
	var html = "";
	var tr_td0 = "<tr class=\"first_line\"><td rowspan=\""+len+"\" class=\"center middle\">"+renderDate(data.date)+"</td>";
	html += printTR(ary[0],tr_td0);
	for(var i=1;i<len;i++){
		html += printTR(ary[i],"<tr>");
	}
	return html;
}
function renderDate(date){
	var d = new Date(date);
	var html = "";
	html += d.getFullYear()+"/";
	html += (d.getMonth()+1)+"/";
	html += d.getDate()+"<br>";
	html += weekName[d.getDay()];
	return html;
}
function printTR(data,html){
	html +="<td class=\"center middle classroom\">"+data.name+"</td>";
	var ary = data.classTimes;
	for(var i=0;i<ary.length;i++){
		html += printClassTime(ary[i],period[i]);
	}
	html += "</tr>";
	return html;
}

function printClassTime(data,period){
	if(data == null){
		return printTD(null,period,attrib[0])
		+printTD(null,period,attrib[1])
		+printTD(null,period,attrib[2]);
	}
	
	return printTD(data.clazz,period,attrib[0])
	+printTD(data.teacher,period,attrib[1])
	+printTD(data.teacher,period,attrib[2]);
}

function printTD(data,period,type){
	//var xy = XY();
	
	//var html = "<td class=\""+period+" "+type+"\" x=\""+xy.x+"\" y=\""+xy.y+"\">";
	var html = "<td class=\""+period+" "+type+"\">";
	if(data == null || data.name == null){
		return html + "</td>";
	}
	
	return html+data.name+"</td>";
}

function getOptionData(entry){
	var info = {};
	info.text = entry.text||entry.name;
	info.val = entry.id||entry.value;
	return info;
}

function createSelectTo(td,items){
	var oldText = td.text();
	td.empty();
	//debugger;
	var defaultVal = null;
	var html = "<select>";
	html += "<option value=\"\"></option>";
	for(var i=0;i<items.length;i++){
		var option = getOptionData(items[i]);
		if(oldText == option.text){
			html += "<option value=\""+option.val+"\" selected=\"selected\">"+option.text+"</option>";
			defaultVal = option.val;
		}else{
			html += "<option value=\""+option.val+"\">"+option.text+"</option>";
		}
	}
	html += "</select>";
	
	if(defaultVal == null){
		defaultVal = getOptionData(items[0]).val;
	}
	td.append(html);
}
/**
 * 隐性约定：<br>
 * 1、一个班级，一天只占用一个教室
 * 2、先选择班级，再选择老师，最后选择课程（简化处理逻辑）
 * 
 */
function showClassSelect(td,clear){
	if(clear){
		//td.empty();
	}
	
	var params = {};
	var cellIndex = getCellIndex(td);
	
	//console.log(params);
	//1、获取当前单元格数据；
	//2、获取相关单元格数据（关联参数）；
	
	var ctInfo = getClassTimeInfo(td);
	
	$.extend(params,ctInfo);
	
//	params.classId=1;
//	params.teacherId=2;
//	params.courseId=3;
	var attrIndex = cellIndex.x%3;
	if(attrIndex==0){//班级
		//已指定老师
		//params.teacherId=
		//未指定老师
	}else if(attrIndex==1){//老师
		//已选择班级:>
		//params.classId=
		//未选择班级:>显示全部老师
		
		
		//后置影响
		//如果选择教员，课程就已确定：设置课程项为确定值，并且为不可修改状态
		//
	}else{//课程
		//班级必须已选择，否则不能选择课程
		
		//已指定老师
		
		//未指定老师
		
	}
	//后置影响
	//一个班次确定，对应的上午或者下午的班次也可以确定，晚自习也可以一键确定
	
	var url = urls[attrIndex];
	
	$.post(url,params,
	function(data){
		//过滤已
		data = rule.rule1(td,data);
		
		//下拉列表显示可选数据
		createSelectTo(td,data);
		//绑定
		td.find("select").on("change",function(event){
			//TODO bjw 修改数据
			var objSelect = $(event.target);
			
			//var val = objSelect.val();
			//获取选中数据
			var text = objSelect.find("option:selected").text();
			//清空当前单元格
			td.empty();
			//重写选中数据到单元格
			//td.text(text);
			var attrIndex = cellIndex.x%3;
			if(attrIndex==0){//班级
				var objTR = td.parent();
				objTR.children("td:nth-child(2)").text(text);
				objTR.children("td:nth-child(5)").text(text);
				objTR.children("td:nth-child(8)").text(text);
			}
			//storeCellText(cellIndex,text);
		});
		//td.find("select").click();
		//td.find("select").trigger("click");
		//td.find("select").triggerHandler("click");
		//showOptions(td.find("select"));
	});
}
/**
 * 获取当天的数据存放区
 */
function getDayStorage(td){
	var objTR = td.parents("tr");
	if(objTR.hasClass("first_line")){//当前班次是当天第一个班次
		var storage = objTR.children("[rowspan]");
		console.log(storage.html());
	}else{
		var storage = td.parents("tr").prevAll(".first_line").children("[rowspan]");
		console.log(storage.html());
	}	
}
function getFirstTr(td){
	var objTR = td.parents("tr");
	if(objTR.hasClass("first_line")){		
		return objTR;
	}else{
		return objTR.prevAll(".first_line");
	}
}

var rule = {
	/**1、班级一天只能选择一次*/
	'rule1':function(cell,data){
		var cellIndex = getCellIndex(cell);
		if(cellIndex.x%3 == 0){
			var tr = getFirstTr(cell);			
			//获取当天已排课班级
			for(var i=0;i<8;i++){
				var text = tr.children("td:nth-child(1)").text();
			}
			//
			return data;
		}else{
			return data;
		}
	}
	,/**2、教员一天只能排两次课，*/
	'rule2':function(cell,data){
		
	}
	/**3、班级一周四次课，放假不能连续两天*/
	/**4、班级人数不能超过教室人数*/
	/**5、一天只能有一次正课*/
	/**6、晚上只能上自习课*/
	
	/**7、一个班一天的课在同一教室*/
	,'rule7':function(cell,data){
		//控制
		//处理
		
		/**
		 * 1、如果该教室已选择了班级，再点击其它班级列时，自动带出已选择班级（下拉列只有两项：已选班级｜置空） 
		 * 2、
		 */
	}
	/**8、修改班级信息，同时清空教师和课程信息；修改老师信息，更新课程下拉列表；教员课程按班级课程节点自动设定；班主任课程，默认自习课*/
	/**9、*/
};
/**
 * 选择班级，触发联动操作
 */
function selectClass(cell,data){
	
}
/**
 * 获取指定单元格对应数据信息
 */
function getCellIndex(cell){
	var x = cell.index();//获取实际列索引
	var y = cell.parent().index();//获取实际行索引
	
	var cellIndex = {};
	if(y%8==0){
		cellIndex.isFirstRoom = true;
		cellIndex.x = x-2;
	}else{
		cellIndex.isFirstRoom = false;
		cellIndex.x = x-1;
	}
	cellIndex.y = y;
	//cellIndex.x0 = x;
	//cellIndex.y0 = y;
	
	return cellIndex;
}
/**
 * 获取当前班次数据
 */
function getClassTimeInfo(cell){
	var cellData = getCellIndex(cell);
	//debugger;
	var info = {};
	if(cellData.x % 3 == 0){
		//info.classText=1;
		info.teacherText=cell.next().text();
		info.courseText=cell.next().next().text();
	}else if(cellData.x % 3 == 1){
		info.classText=cell.prev().text();
		//info.teacherText=2;
		info.courseText=cell.next().text();
	}else if(cellData.x % 3 == 2){
		info.classText=cell.prev().prev().text();
		info.teacherText=cell.prev().text();
		//info.courseText=3;
	}
	
	return info;
		
}
function showOptions(select){
	
	var element = select[0];
	if (document.createEvent) { // all browsers
	    var e = document.createEvent("MouseEvents");
	    e.initMouseEvent("mousedown", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
	    element.dispatchEvent(e);
	} else if (element.fireEvent) { // ie
	    element.fireEvent("onmousedown");
	}
}
win.timetable = function(cfg){
	var box = $("#"+cfg.id);
	//box.append(table);	
	
	//绑定点击事件
	box.find("table>tbody").bind("click",function(event){
		var elem = $(event.target);
		
		if(elem.tab()[0].tagName == "TD" && elem.find("select").length == 0 && getCellIndex(elem).x>-1){
			showClassSelect(elem,false);
		}else if(elem.tab()[0].tagName="SELECT"){
			//debugger;
			var cellIndex = getCellIndex(elem);
			console.log(cellIndex);
			//TODO 再次点击select控件
			var objTD = elem.parent();
			//showClassSelect(objTD,true);
		}
	});
	
	cfg.refresh=function(){
		$.post(this.url, {date:this.date},
		function(data){
			//debugger;
			box.find("table>tbody").append(printWeeks(data));
		});
	};
	
	return cfg;	
}
}(window,jQuery);