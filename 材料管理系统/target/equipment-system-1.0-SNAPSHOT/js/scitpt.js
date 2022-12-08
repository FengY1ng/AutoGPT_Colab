const menuToggle = document.querySelector('.menuToggle')
const navigation = document.querySelector('.navigation')

menuToggle.onclick = function () {
  navigation.classList.toggle('active')
}

const list = document.querySelectorAll('.list')

function activeLink() {
  list.forEach((item) =>
  item.classList.remove('active'))
  this.classList.add('active')
}

list.forEach((item) =>
  item.addEventListener('click', activeLink)
)