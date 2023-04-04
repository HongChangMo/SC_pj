ClassicEditor
	.create( document.querySelector('#editor'),{
		language:"ko",
		mediaEmbed: {
      		previewsInData: true
    	},
    	toolbar:{
			items:[
				'heading', '|', 
				'undo','redo','|', 
				'imageStyle:alignLeft','imageStyle:alignCenter','imageStyle:alignRight','|', 
				'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote', 'ckfinder', 'mediaEmbed','uploadImage'],
			shouldNotGroupWhenFull:true
			},
    	ckfinder:{
			uploadUrl: '/file/upload/image',
			options:{
				resourceType:'Images'
			}
		},
		htmlSupport: {
            allow: [
                {
                    name: /.*/,
                    attributes: true,
                    classes: true,
                    styles: true
                }
            ]
        },
        htmlEmbed: {
            showPreviews: true
        },
	})
	.then( newEditor => {
		console.log(editor);
		editor = newEditor;
	})
	.catch( error => {
		console.error(error);
	});
