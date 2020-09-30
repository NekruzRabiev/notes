function validateForm() {
  var x = document.forms["saveForm"]["content"].value;
  if (x.trim() == "") {
    alert("Content must be filled out");
    return false;
  }
}