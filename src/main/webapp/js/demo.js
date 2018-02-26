/**
 * 
 */

$(function() {
	// 默认绑定省
	ProviceBind();
	// 绑定事件
	$("#Province").change(function() {
		CityBind();
	})

	$("#City").change(function() {
		VillageBind();
	})

})
function Bind(str) {
	alert($("#Province").html());
	$("#Province").val(str);
}

function ProviceBind() {
	// 清空下拉数据
	$("#Province").html("");

	var str = "<option>==请选择===</option>";
	$.ajax({
		type : "POST",
		url : "/Home/GetAddress",
		data : {
			"parentiD" : "",
			"MyColums" : "Province"
		},
		dataType : "JSON",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data.Data, function(i, item) {
				str += "<option value=" + item.Id + ">" + item.MyTexts
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#Province").append(str);
		},
		error : function() {
			alert("Error");
		}
	});

}
function CityBind() {

	var provice = $("#Province").attr("value");
	// 判断省份这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#City").html("");
	var str = "<option>==请选择===</option>";

	$.ajax({
		type : "POST",
		url : "/Home/GetAddress",
		data : {
			"parentiD" : provice,
			"MyColums" : "City"
		},
		dataType : "JSON",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data.Data, function(i, item) {
				str += "<option value=" + item.Id + ">" + item.MyTexts
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#City").append(str);
		},
		error : function() {
			alert("Error");
		}
	});

}
function VillageBind() {

	var provice = $("#City").attr("value");
	// 判断市这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#Village").html("");
	var str = "<option>==请选择===</option>";
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "POST",
		url : "/Home/GetAddress",
		data : {
			"parentiD" : provice,
			"MyColums" : "Village"
		},
		dataType : "JSON",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data.Data, function(i, item) {
				str += "<option value=" + item.Id + ">" + item.MyTexts
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#Village").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
	// $.post("/Home/GetAddress", { parentiD: provice, MyColums: "Village" },
	// function (data) {
	// $.each(data.Data, function (i, item) {
	// str += "<option value=" + item.Id + ">" + item.MyTexts + "</option>";
	// })
	// $("#Village").append(str);
	// })
}