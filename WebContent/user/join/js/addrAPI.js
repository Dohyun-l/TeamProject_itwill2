let callAddress = () =>{
	let inputTarget = document.querySelector("#addr");
    new daum.Postcode({
        oncomplete: function(data) {
            console.log(data.address);
            inputTarget.value = data.address;
            inputTarget.style.color='gray';
        }
    }).open();
}
// const ee = document.querySelector("#qwe");
// ee.addEventListener("click", (e) => { e.preventDefault(); console.log(e.target.innerText);});
// ee.focus();