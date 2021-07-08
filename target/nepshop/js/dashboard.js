/* ***************************** */
// toggle side panel nav
/* ***************************** */

const btnOpenNav = document.querySelector(".btn-open-nav");
const btnCloseNav = document.querySelector(".btn-close-nav");
const sidePanel = document.querySelector(".side-panel");

btnOpenNav.addEventListener("click", () => {
  sidePanel.classList.toggle("show");
});

btnCloseNav.addEventListener("click", () => {
  sidePanel.classList.remove("show");
});

// sticky main header
// sticky navbar
const mainHeader = document.querySelector(".main-header");

window.addEventListener("scroll", () => {
    const scrollHeight = window.pageYOffset - 16;
    const mainHeaderHeight = mainHeader.getBoundingClientRect().height;
    if(scrollHeight > mainHeaderHeight){
        mainHeader.classList.add("sticky");
    }
    else {
        mainHeader.classList.remove("sticky");
    }
});


/* ***************************** */
// toggle profile submenu
/* ***************************** */

const profileSubmenu = document.querySelector(".profile-submenu");

document.addEventListener("click", (e) => {
  if (
    !e.target.parentElement.classList.contains("down-arrow-icon") &&
    !e.target.classList.contains("main-header-pp") &&
    !e.target.parentElement.classList.contains("profile-submenu")
  ) {
    profileSubmenu.classList.remove("show");
  }

  if (
    e.target.parentElement.classList.contains("down-arrow-icon") ||
    e.target.classList.contains("main-header-pp")
  ) {
    profileSubmenu.classList.toggle("show");
  }
});

/* ***************************** */
// toggle popup modal
/* ***************************** */
const table = document.querySelector(".table");
const btnCreateOpenAll = document.querySelectorAll(".btn-create-open");
const btnUpdateOpenAll = document.querySelectorAll(".btn-update-open");
const btnDeleteOpenAll = document.querySelectorAll(".btn-delete-open");
const btnCancelAll = document.querySelectorAll(".btn-cancel");
const overlayAll = document.querySelectorAll(".overlay");

if (table) {
  btnCreateOpenAll.forEach((btnCreateOpen) => {
    btnCreateOpen.addEventListener("click", () => {
      overlayAll.forEach((overlay) => {
        overlay.classList.remove("open-overlay");
      });
      document.querySelector(".create-overlay").classList.add("open-overlay");
    });
  });

  btnDeleteOpenAll.forEach((btnDeleteOpen) => {
    btnDeleteOpen.addEventListener("click", () => {
      const deleteOverlay = document.querySelector(".delete-overlay");
      overlayAll.forEach((overlay) => {
        overlay.classList.remove("open-overlay");
      });
      deleteOverlay.classList.add("open-overlay");
      deleteOverlay.dataset.id = btnDeleteOpen.dataset.id;
    });
  });

  btnUpdateOpenAll.forEach((btnUpdateOpen) => {
    btnUpdateOpen.addEventListener("click", () => {
      overlayAll.forEach((overlay) => {
        overlay.classList.remove("open-overlay");
      });
      document.querySelector(".update-overlay").classList.add("open-overlay");
    });
  });

  btnCancelAll.forEach((btnCancel) => {
    btnCancel.addEventListener("click", () => {
      overlayAll.forEach((overlay) => {
        overlay.classList.remove("open-overlay");
      });
    });
  });

  // delete confirm
  // const btnConfirm = document.querySelector(".btn-delete-confirm");
  // btnConfirm.addEventListener("click", (e) => {
  //   e.preventDefault();
  //   const deleteOverlay = document.querySelector(".delete-overlay");
  //   const id = deleteOverlay.dataset.id;
  //   window.location.href = "/userservlet?action=delete&id=" + id;
  // });
}

const deleteData = (servlet) => {
  const deleteOverlay = document.querySelector(".delete-overlay");
  const id = deleteOverlay.dataset.id;
  window.location.href = `/${servlet}?action=delete&id=${id}`;
}


/* ***************************** */
// account settings tabs
/* ***************************** */
const settingsPage = document.querySelector(".account-settings-page");
const btnSettingsTab = document.querySelectorAll(".btn-settings-tab");
const settingsTabContent = document.querySelectorAll(".settings-tab-content");

if (settingsPage) {
  // control settings tabs activeness
  settingsPage.addEventListener("click", (e) => {
    const id = e.target.dataset.id;
    if (id) {
      const currentBtn = e.target;
      const currentContent = document.getElementById(id);

      btnSettingsTab.forEach((btn) => {
        btn.classList.remove("active");
      });

      settingsTabContent.forEach((content) => {
        content.classList.remove("active");
      });

      currentBtn.classList.add("active");
      currentContent.classList.add("active");
    }
  });

  // delete account modal overlay
  const deleteAcPassword = document.querySelector("#delete-ac-password");
  const deleteAccountForm = document.querySelector(".delete-ac-form"); 
  const btnDeleteCancel = document.querySelector(".btn-delete-cancel");
  const btnDeleteAccount = document.querySelector(".btn-delete-account");
  const deleteAccountOverlay = document.querySelector(
    ".delete-account-overlay"
  );

  btnDeleteAccount.addEventListener("click", (e) => {
    e.preventDefault();
    deleteAcPassword.nextElementSibling.classList.remove("show");
    if(deleteAcPassword.value !== ""){
      deleteAccountOverlay.classList.add("open-overlay");
      deleteAccountForm.password.value = deleteAcPassword.value;
    }
    else {
      deleteAcPassword.nextElementSibling.classList.add("show");
    }
  });

  btnDeleteCancel.addEventListener("click", () => {
    deleteAccountOverlay.classList.remove("open-overlay");
  });
}

/* ***************************** */
// toggle theme
/* ***************************** */

const btnToggleTheme = document.querySelector(".btn-toggle-theme");

btnToggleTheme.addEventListener("click", () => {
  const currentTheme = localStorage.getItem("theme");

  if (currentTheme === "dark-theme") {
    document.documentElement.className = "light-theme";
  } else {
    document.documentElement.className = "dark-theme";
  }
  localStorage.setItem("theme", document.documentElement.className);
});

document.addEventListener("DOMContentLoaded", () => {
  const localStorageTheme = localStorage.getItem("theme") || "dark-theme";
  document.documentElement.className = localStorageTheme;
});

// form validation
const validateEmail = (email) => {
  const pattern = /^([a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?)$/;
  return pattern.test(email);
}

const validateForm = (form) => {
    const inputAll = document.querySelectorAll(`#${form} input:not(.not-mandatory)`);
    const newPassword = document.querySelector("input[name='new-password']");
    const confirmPassword = document.querySelector("input[name='confirm-password']");
    const formEl = document.getElementById(form);
    const selectElAll = formEl.querySelectorAll("select");

    let flag= true;
    inputAll.forEach(input => {
        input.nextElementSibling.classList.remove("show");
        input.classList.remove("input-error");
    });

    // validate empty fields
    selectElAll.forEach(selectEl => {
        if(selectEl.value == ""){
            selectEl.nextElementSibling.classList.add("show");
            selectEl.classList.add("input-error");
            flag=false;
        }
        else {
            selectEl.nextElementSibling.classList.remove("show");
            selectEl.classList.remove("input-error");
        }
    });

    inputAll.forEach(input => {
        if(input.value == ""){
            input.nextElementSibling.classList.add("show");
            input.classList.add("input-error");
            flag=false;
        }
    });
    // validate email
    if(formEl.email){
      if(formEl.email.value != ""){
         if(!validateEmail(formEl.email.value)){
            formEl.email.classList.add("input-error");
            formEl.email.nextElementSibling.innerHTML = `
            <span><i class="fas fa-exclamation-circle"></i></span>
            <span>Email is not valid</span>
            </div>`;
            formEl.email.nextElementSibling.classList.add("show");
            flag=false;
          }
      }
      else {
        formEl.email.classList.add("input-error");
            formEl.email.nextElementSibling.innerHTML = `
            <span><i class="fas fa-exclamation-circle"></i></span>
            <span>Email is required</span>
            </div>`;
            formEl.email.nextElementSibling.classList.add("show");
            flag=false;
      }
    }
    // validate create and update form password
    if(formEl.password){
      if(formEl.password.value == ""){
        formEl.password.classList.add("input-error");
        formEl.password.nextElementSibling.innerHTML = `
        <span><i class="fas fa-exclamation-circle"></i></span>
        <span>Password is required</span>
        </div>`;
        formEl.password.nextElementSibling.classList.add("show");
        flag=false;
      }
      else if(!(formEl.password.value.length >= 8)){
        formEl.password.classList.add("input-error");
        formEl.password.nextElementSibling.innerHTML = `
        <span><i class="fas fa-exclamation-circle"></i></span>
        <span>Must be at least 8 characters</span>
        </div>`;
        formEl.password.nextElementSibling.classList.add("show");
        flag=false;
      }
    }
    // validate confirm password
    if(form === "update-password-form" && flag){
      if(!(newPassword.value.length >= 8)){
        newPassword.classList.add("input-error");
        newPassword.nextElementSibling.innerHTML = `
        <span><i class="fas fa-exclamation-circle"></i></span>
        <span>Must be at least 8 characters</span>
        </div>`;
        newPassword.nextElementSibling.classList.add("show");
        flag=false;
      }

      if(newPassword.value.toLowerCase().trim() != confirmPassword.value.toLowerCase().trim() && flag){
        confirmPassword.nextElementSibling.classList.add("show");
        confirmPassword.nextElementSibling.innerHTML = `
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Confirm password not matched</span>
                    </div>`;
        newPassword.classList.add("input-error");
        confirmPassword.classList.add("input-error");
        flag=false; 
      }
    }
    return flag;
}


// custom toast message
const toastMessageContainer = document.querySelector(".toast-message-container");


const toastMessage = (message, type) => {
    let icon;
    if(type == "error"){
        icon = "times-circle";
    }
    else if(type == "success") {
        icon = "check-circle";
    }
    else if(type == "warning") {
        icon = "exclamation-circle";
    }
    else if(type == "info") {
        icon = "info-circle";
    }
    else {
      icon = "exclamation-triangle";
    }
    return `
        <div class='toast-message ${type}'>
            <span class='toast-message-icon'>
                <i class='fa fa-${icon}'></i>
            </span>
            <div class="toast-message-text">
                <span>${type}!</span>
                <span>${message}</span>
            </div>
        </div> 
    `;
}

let timerId;
const showToastMessage = (message, type) => {
    if(type === "no-message" || type === ""){
      return;
    }
    toastMessageContainer.classList.add("show");
    toastMessageContainer.innerHTML = toastMessage(message,type);
    clearTimeout(timerId);
    timerId = setTimeout(() =>{
        toastMessageContainer.classList.remove("show");
    }, 3000);
}

//search table
const searchTable = (column) => {
  const searchField = document.querySelector(".table-search").value.toLowerCase().trim();
  const rowAll = document.querySelectorAll("tbody tr");
  
  rowAll.forEach((row, index) => {
    const cellAll = row.querySelectorAll("td");
    const cell = cellAll[column-1];
    const content = cell.textContent;
    if(content.toLowerCase().indexOf(searchField) <= -1){
      row.style.display = "none";
    }
    else {
      row.style.display = "";
    }
  });
  
  const emptyMessage = document.querySelector(".table-empty-message");
  const hiddenRowAll = document.querySelectorAll("tr[style='display: none;']");
  if(hiddenRowAll.length == rowAll.length) {
    emptyMessage.classList.add("show");
  }
  else {
    emptyMessage.classList.remove("show");
  }
} 

