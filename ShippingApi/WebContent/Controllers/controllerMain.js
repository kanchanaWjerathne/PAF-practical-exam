$(document).on("click", "#btnLogin",function()
{
	$("#divStsMsgLogin").html("");
	var result = isValidFormLogin();
	
	if(result=="true")
	{
		$.ajax(
		{
			type : "post",
			url : "UserLogin",
			data : $("#formLogin").serialize(),
			complete : function(response, status)
			{
				onLogingComplete(response.responseText, status);
			}
		});
	
	}
	else
	{
		$("#divStsMsgLogin").html(result);
	}
});

function onLogingComplete(response, status)
{
	if(status == "SUCCESS")
	{
		if(response == "SUCCESS")
		{
			document.location = "items.jsp";
		}
		else
		{
			$("#divStsMsgLogin").html(response);
		}
	}
	else if(status == "error")
	{
		$("#divStsMsgLogin").html("Error while authentication");
	}
	
	else
	{
		$("#divStsMsgLogin").html("Unknown error while authenticating");
	}
}

function isValidFormLogin()
{
	if($.trim($("#txtUserName").val())=="")
	{
		return "Enter Username";
	}
	if($.trim($("#txtUserName").val())=="")
	{
		return "Enter Password";
	}
}

function isValidFormLogin()
{
	if($.trim($("#txtItemName").val())=="")
	{
		return "Enter Item name";
	}
	if($.trim($("#txtItemDesc").val())=="")
	{
		return "Enter Item description";
	}
}

//--Save-------------------------------------
$(document).on("click", "#btnSave", function()
{
var validity = isValidFormItem();
if (validity == "true")
 {
 var method = "post";
 if ($("#hidItemID").val() != "0")
 {
 method = "put";
 }
 $("#divStsMsgItem").html("Saving...");
 $.ajax(
 {
 type : method,
 url : "Item",
 data : $("#formItems").serialize(),
 complete : function(response, status)
 {
 onSaveUpdateComplete(response.responseText, status);
 }
 });
 }
else
{
	 $("#divStsMsgItem").html(validity);
}
});

function onSaveUpdateComplete(response, status)
	{
	if (status == "success")
	 {
	 $("#formItems")[0].reset();
	 $("#divItemsTable").html(response);
	 $("#divStsMsgItem").html("Saved successfully");
	 $("#hidItemID").val("0");
	 }
	else if (status == "error")
	 {
	 $("#divStsMsgItem").html("Error while saving");
	 }
	else
	 {
	 $("#divStsMsgItem").html("Unknown error while saving");
	 }
} 

//--Edit-------------------------------------------------------
$(document).on("click", "#btnEdit", function()
{
 $("#hidItemID").val($(this).data("itemid"));
 $("#txtItemName").val($(this).closest("tr").find("td:eq(1)").text());
 $("#txtItemDesc").val($(this).closest("tr").find("td:eq(2)").text());
}); 

//--Delete-----------------------------------------------------
$(document).on("click", "#btnRemove", function()
{
 $("#divStsMsgItem").html("Removing...");
 $.ajax(
 {
 type : "delete",
 url : "Item",
 data : "itemID=" + $(this).data("itemid"),
 complete : function(response, status)
 {
 onItemDeleteComplete(response.responseText, status);
 }
 });
});

function onItemDeleteComplete(response, status)
{
	if (status == "success")
	 {
	 $("#divItemsTable").html(response);
	 $("#divStsMsgItem").html("Removed successfully");
	 }
	else if (status == "error")
	 {
	 $("#divStsMsgItem").html("Error while removing");
	 }
	else
	 {
	 $("#divStsMsgItem").html("Unknown error while removing");
	 }
}

//--Refresh-------------------------------------
$(document).on("click", "#btnRefresh", function()
{
 $("#divStsMsgItem").html("Loading...");
 $.ajax(
 {
 type : "get",
 url : "Item",
 complete : function(response, status)
 {
 onRefreshComplete(response.responseText, status);
 }
 });
}); 

function onRefreshComplete(response, status)
{
	if (status == "success")
	 {
	 $("#divItemsTable").html(response);
	 $("#divStsMsgItem").html("Loaded successfully");
	 }
	else if (status == "error")
	 {
	 $("#divStsMsgItem").html("Error while loading");
	 }
	else
	 {
	 $("#divStsMsgItem").html("Unknown error while loading");
	 }
} 
