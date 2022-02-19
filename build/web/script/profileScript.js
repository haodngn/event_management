/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$ = document.querySelector.bind(document);
$$ = document.querySelectorAll.bind(document);

const btnEdit = $('.btn-edit')
const btnList = $('.btn-list')
const userInfos = $$('.info .info-row span:nth-last-of-type(1)')
const infoRows = $$('.info .info-row')

btnEdit.addEventListener('click', (e) => {
    if (btnEdit.innerText === 'Edit Profile') {
        btnEdit.innerText = 'Save'
        console.log(e.target.value)
        
        const fullNameField = document.createElement('input')
        const emailField = document.createElement('input')
        const addressField = document.createElement('input')
        const phoneField = document.createElement('input')
        const genderField = document.createElement('input')

        const fieldArr = [fullNameField, emailField, addressField, phoneField, genderField]

        fullNameField.setAttribute('name', 'txtFullname');
        emailField.setAttribute('name', 'txtEmail');
        addressField.setAttribute('name', 'txtAddress');
        phoneField.setAttribute('name', 'txtPhoen');
        genderField.setAttribute('name', 'txtGender');

        fieldArr.forEach(field => {
            field.classList.add('input-field')
        })

        userInfos.forEach((row) => {
            row.classList.add('hide')
        })

        infoRows.forEach((row, index) => {
            row.appendChild(fieldArr[index])
        })
    } else {
        const newInfo = {
            newFullname: 'Đặng Dương Khâm',
            newEmail: 'dangduongkham1703@gmail.com',
            newAddress: 'HCM',
            newPhone: '0936-088-291',
            newGender: 'Male'
        }
        const inputFields = $$('.input-field')
        inputFields.forEach(row => {
            row.classList.add('hide')
        })

        userInfos.forEach(row => {
            row.classList.remove('hide')
            // Update new info here
        })

        btnEdit.innerText = 'Edit Profile'
    }
})



