/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

const inputFields = $$('.input-field input');

function checkFocusInput() {
    const parent = this.parentNode;
    parent.classList.add('focus');
}

function showPlaceHolder() {
    const parent = this.parentNode;
    if(this.value === "") {
        parent.classList.remove('focus');
    }
}

inputFields.forEach(inputField => {
    inputField.addEventListener('focus', checkFocusInput);
    inputField.addEventListener('blur', showPlaceHolder);
});