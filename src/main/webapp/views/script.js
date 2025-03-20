document.addEventListener("DOMContentLoaded", () => {
    const uploadForm = document.getElementById("uploadForm");
    const fileInput = document.getElementById("fileInput");
    const uploadStatus = document.getElementById("uploadStatus");
    const viewFilesBtn = document.getElementById("viewFilesBtn");
    const filesList = document.getElementById("filesList");

    // Handle file upload
    uploadForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const file = fileInput.files[0];
        if (file) {
            // Simulate a successful upload (you can replace with actual API call)
            uploadStatus.textContent = `Uploading ${file.name}...`;
            setTimeout(() => {
                uploadStatus.textContent = "File uploaded successfully!";
                uploadStatus.style.color = "green";
                fileInput.value = "";
            }, 1000);
        } else {
            uploadStatus.textContent = "Please select a file to upload!";
            uploadStatus.style.color = "red";
        }
    });

    // Handle viewing files
    viewFilesBtn.addEventListener("click", () => {
        // Simulate fetching file list (replace with actual API call)
        const fakeFiles = ["file1.txt", "document.pdf", "image.jpg"];
        filesList.innerHTML = ""; // Clear the list
        fakeFiles.forEach((file) => {
            const li = document.createElement("li");
            li.textContent = file;
            filesList.appendChild(li);
        });
    });
});
