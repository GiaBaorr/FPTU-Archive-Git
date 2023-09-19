function CalTotal() {
  var name = [
    "Coconut cream",
    "Strawberry ice-cream",
    "Durian ice-cream",
    "Butter cream",
    "Jackfruit ice cream",
    "Lychee Tea",
    "Kumquat Tea",
    "Peach Tea",
  ];
  let price = [2, 2.5, 3, 2, 3, 3, 2, 2.5];
  document.getElementById("list-block").style.display = "block";
  document.getElementById("total").style.display = "block";

  let arr = document.getElementsByClassName("order-value");
  let ul = document.getElementById("order-list");
  let total = 0;

  ul.innerHTML = "";

  for (let i = 0; i < arr.length; i++) {
    if (arr[i].checked) {
      total += price[i];
      ul.innerHTML = ul.innerHTML + "<li>" + name[i] + "</li>";
    }
  }
  document.getElementById("total").innerHTML =
    "<h3>Total amount: " + total + "$</h3";
}
