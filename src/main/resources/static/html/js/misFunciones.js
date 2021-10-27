function get(){
    $.ajax({
        url:"http://localhost:80/api/Category/all",
        type : "GET",
        datatype:"JSON",
        success:function(answer){
            console.log(answer);
            paintAnswer(answer);
        }
    });
}

function paintAnswer(answer){

    let myTable="<table>";
    for(i=0;i<answer.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+answer[i].name+"</td>";
        myTable+="<td>"+answer[i].description+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>"
    $("#result").append(myTable);
}

function save(){
	let var2 ={
        name:$("#Cname").val(),
        description:$("#Cdescription").val()
    };

    	$.ajax({
        	type: "POST",
        	contentType: "aplication/json; charset=utf-8",
        	datatype: "JSON",
        	data: JSON.stringify(var2),

        	url:"http://localhost:80/api/Category/save",

        	success:function(responce){
            		console.log(responce);
            	console.log("Guardado exitoso");
            	alert("Guardado");
            	window.location.reload()
        	},

       	 	error: function(jqXHR, textStatus, errorTrown){
                	//window.location.reload()
            	alert("Guardado fallido");
        	}
    	});
}