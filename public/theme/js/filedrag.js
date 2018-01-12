/*
filedrag.js - HTML5 File Drag & Drop demonstration
Featured on SitePoint.com
Developed by Craig Buckler (@craigbuckler) of OptimalWorks.net
*/
(function() {

	// getElementById
	function $id(id) {
		return document.getElementById(id);
	}


	// output information
	function Output(msg) {
		//var m = $id("messages");
		//m.innerHTML = msg + m.innerHTML;
	}


	// file drag hover
	function FileDragHover(e) {
		e.stopPropagation();
		e.preventDefault();
		e.target.className = (e.type == "dragover" ? "hover" : "");
	}


	// file selection
	function FileSelectHandler(e) {

		// cancel event and hover styling
		FileDragHover(e);

		// fetch FileList object
		var files = e.target.files || e.dataTransfer.files;
		if(files.length > 5){
			alert("Please upload only 5 Images")
			e.target.value='';
		}else{
			// process all File objects
			for (var i = 0, f; f = files[i]; i++) {
				if(ParseFile(f) == false){
					e.target.value='';
					alert("Please upload only Images")
				}
				
			}
		}
		

	}


	// output file information
	function ParseFile(file) {
		if(file.type.indexOf("image") != 0){
			return false;
		}
		
		Output(
			"<p>File information: <strong>" + file.name +
			"</strong> type: <strong>" + file.type +
			"</strong> size: <strong>" + file.size +
			"</strong> bytes</p>"
		);
		$("#preview").empty();
		if (file.type.indexOf("image") == 0) {
			var reader = new FileReader();
			reader.onload = function(e) {
//				Output(
//					"<div class='col-md-6'>" +
//					'<img src="' + e.target.result + '" /></p><div>'
//				);
				$("#preview").append("<div class='col-md-2' style='padding:10px'><img class='img img-responsive' src='"+e.target.result+"' height='200' width='200'/></div>");
			}
			reader.readAsDataURL(file);
		}

	}


	// initialize
	function Init() {

		var fileselect = $id("fileselect"),
			filedrag = $id("filedrag"),
			submitbutton = $id("submitbutton");

		// file select
		fileselect.addEventListener("change", FileSelectHandler, false);

		// is XHR2 available?
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {

			// file drop
			filedrag.addEventListener("dragover", FileDragHover, false);
			filedrag.addEventListener("dragleave", FileDragHover, false);
			filedrag.addEventListener("drop", FileSelectHandler, false);
			filedrag.style.display = "block";

			// remove submit button
			submitbutton.style.display = "none";
		}

	}

	// call initialization file
	if (window.File && window.FileList && window.FileReader) {
		Init();
	}


})();