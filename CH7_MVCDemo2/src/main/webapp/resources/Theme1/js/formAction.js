function memberEnable(user,pass,name,address,districts,amphures,provinces){
	user.removeAttr("readonly");
	pass.removeAttr("readonly");
	name.removeAttr("readonly");
	address.removeAttr("readonly");
	districts.removeAttr("disabled");
	amphures.removeAttr("disabled");
	provinces.removeAttr("disabled");
}

function memberDisable(user,pass,name,address,districts,amphures,provinces){
	user.attr("readonly","true");
	pass.attr("readonly","true");
	name.attr("readonly","true");
	address.attr("readonly","true");
	districts.attr("disabled","true");
	amphures.attr("disabled","true");
	provinces.attr("disabled","true");
}