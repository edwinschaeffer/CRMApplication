function callServer() {
	alert("called");
	let plId = $("#plID").val();
	$.ajax({
		method: "GET",
		url: "/callServer",
		data: { plId: plId }
	})
		.done(function(msg) {
			alert("Data Saved: " + msg);
		});
}