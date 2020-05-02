function encode() {
    const selectedFile = document.getElementById("fileInput").files;
    if (selectedFile.length > 0) {
        const imageFile = selectedFile[0];
        const fileReader = new FileReader();
        fileReader.onload = function (fileLoadedEvent) {
            const srcData = fileLoadedEvent.target.result;

            document.getElementById("image-holder").src = srcData;
            document.getElementById("image").value = srcData;
        };
        fileReader.readAsDataURL(imageFile);
    }
}