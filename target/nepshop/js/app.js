// sticky navbar
const navbar = document.querySelector(".navbar");
const navbarBottom = document.querySelector(".navbar-bottom");

window.addEventListener("scroll", () => {
    const scrollHeight = window.pageYOffset;
    const navbarHeight = navbar.getBoundingClientRect().height;
    if(scrollHeight > navbarHeight){
        navbarBottom.classList.add("sticky");
    }
    else {
        navbarBottom.classList.remove("sticky");
    }
});

// mobile menu
const navmenu = document.querySelector(".mobile-navmenu");
const btnNavmenuOpen = document.querySelector(".btn-navmenu-open");
const btnNavmenuClose = document.querySelector(".btn-navmenu-close");

btnNavmenuOpen.addEventListener("click", () => {
    navmenu.classList.toggle("show");
})

btnNavmenuClose.addEventListener("click", () => {
    navmenu.classList.remove("show");
})

/* ***************************** */
// crud modal overlay
/* ***************************** */
// const btnCancelAll = document.querySelectorAll(".btn-cancel");
// const overlayAll = document.querySelectorAll(".overlay");

// btnCancelAll.forEach((btnCancel) => {
//   btnCancel.addEventListener("click", () => {
//     overlayAll.forEach((overlay) => {
//       overlay.classList.remove("open-overlay");
//       const url = "/userservlet?action=list";
//       window.location.href= url;
//     });
//   });
// });

// const btnUpdateOpenAll = document.querySelectorAll(".btn-update-open");
// btnUpdateOpenAll.forEach((btnUpdate) => {
//   btnUpdate.addEventListener("click", (e) => {
//   e.preventDefault();
//     const currOverlay =
//       e.currentTarget.parentElement.parentElement.parentElement.parentElement
//         .parentElement.nextElementSibling.nextElementSibling;
//     const overlay = document.querySelector(".update-overlay");
//     const id = btnUpdate.dataset.id;
//     const url = "/userservlet?action=populate&id="+id;
//     window.location.href= url;
//     window.history.replaceState( {} , title, url );
//     currOverlay.classList.add("open-overlay");
//   });
// });

// const btnCreateOpenAll = document.querySelectorAll(".btn-create-open");
// btnCreateOpenAll.forEach((btnCreate) => {
//   btnCreate.addEventListener("click", (e) => {
//     const currOverlay =
//       e.currentTarget.parentElement.nextElementSibling.nextElementSibling;
//     currOverlay.classList.add("open-overlay");
//   });
// });

// const btnDeleteOpenAll = document.querySelectorAll(".btn-delete-open");
// btnDeleteOpenAll.forEach((btnDelete) => {
//   btnDelete.addEventListener("click", (e) => {
//     const currOverlay =
//       e.currentTarget.parentElement.parentElement.parentElement.parentElement
//         .parentElement.nextElementSibling.nextElementSibling.nextElementSibling;
//     currOverlay.classList.add("open-overlay");
//     currOverlay.dataset.id = btnDelete.dataset.id;
//   });
// });

// const btnConfirm = document.querySelector(".btn-delete-confirm");
// btnConfirm.addEventListener("click", (e)=>{
//     e.preventDefault();
//     const overlay = document.querySelector(".delete-overlay");
//     const id = overlay.dataset.id;
//     window.location.href="/userservlet?action=delete&id="+id;
// });



/* ***************************** */
//
/* ***************************** */

// form validation
const validateForm = (form) => {
    const inputAll = document.querySelectorAll(`.${form} input`);
    let flag= true;
    inputAll.forEach(input => {
        input.nextElementSibling.classList.remove("show");
    });
    inputAll.forEach(input => {
        if(input.value == ""){
            input.nextElementSibling.classList.add("show");
            flag=false;  
        }
    });
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

/***********/
// shopping cart
/***********/
const cartItemsEl = document.querySelector(".cart-items");
const cartOverlay = document.querySelector(".cart-overlay");
const btnCloseCart = document.querySelector(".btn-close-cart");
let cart;

const cartSubTotalCost = document.querySelector(".cart-subtotal-cost");
const cartTotalCost = document.querySelector(".cart-total-cost");
const cartShippingCost = document.querySelector(".cart-shipping-cost");
const cartTotalItemQuantityAll = document.querySelectorAll(".cart-total-item-quantity");
let shippingCost = 100;

// show cart
const showCart = () => {
 cartOverlay.classList.add("show");
}

// close cart
if(btnCloseCart) {
    btnCloseCart.addEventListener("click", () => {
        cartOverlay.classList.remove("show");
    });
}

// get from local storage
const getStorageCart = () => {
    let cart = localStorage.getItem("nepshopCart");
    if(cart) {
        return JSON.parse(cart);
    }
    else {
        return [];
    }
};
// initialize cart
cart = getStorageCart();

// set local storage 
const setStorageCart = (cart) => {
   localStorage.setItem("nepshopCart", JSON.stringify(cart));
}

// add new cart item to DOM
const addToCartDOM = ({id, name, price, photo, quantity}) => {
    const cartItemEl = document.createElement("article");
    cartItemEl.classList.add("cart-item");
    cartItemEl.setAttribute("data-id", id);
    cartItemEl.innerHTML = `
        <div class="cart-item-img-container">
            <img src="${photo}" alt="${name}" class="cart-item-img">
        </div>
        <div class="cart-item-details">
            <span class="cart-item-name">${name}</span>
            <span class="cart-item-price">Rs. ${price}</span>
            <span class="btn-remove-cart-item" data-id="${id}"><i class="fas fa-trash-alt"></i></span>
        </div>
        <div class="cart-item-quantity-change">
            <span class="cart-item-quantity-increase" data-id="${id}" onclick="increaseQuantity(${id})">
            <i class="fas fa-plus"></i>
            </span>
            <span class="cart-item-quantity" data-id="${id}">${quantity}
            </span>
            <span class="cart-item-quantity-decrease" data-id="${id}"
            onclick="decreaseQuantity(${id})"
            >
            <i class="fas fa-minus"></i>
            </span>
        </div>
    `;
    cartItemsEl.appendChild(cartItemEl);
}

// display total cart item quantity
const displayTotalCartItemQuantity = () => {
    const totalQuantity = cart.reduce((total, item) => total + item.quantity,0);
    cartTotalItemQuantityAll.forEach(cartTotalItemQuantity => {
        cartTotalItemQuantity.innerText = `${totalQuantity}`;
    });
}

// display shippingCost
const displayShippingCost = () => {
    cartShippingCost.innerText = `Rs. ${shippingCost}`;
}

// display sub total cost
const getSubTotalCost = () => {
    return cart.reduce((total, item)=> (total + item.quantity * item.price),0);
}

// display subtotal cost
const displaySubTotalCost = () => {
    cartSubTotalCost.innerText = `Rs. ${getSubTotalCost()}`;
}

// display total cost
const displayTotalCost = () => {
    const totalCost = getSubTotalCost() + shippingCost;
    if(totalCost == 100) {
        cartTotalCost.innerText = `Rs. 0`;
        cartShippingCost.innerText = `Rs. 0`;
    }    
    else {
        cartTotalCost.innerText = `Rs. ${totalCost}`;
        displayShippingCost();
    }
}

// display all cost 
const displayAllTotalCost = () => {
    displaySubTotalCost();
    displayTotalCost();
}   

// add product to cart 
const addToCart = (id, name, price, photo) => {
   let item = cart.find(cartItem => cartItem.id === id);
   if(!item){
       //get cart item and add quantity property with value 1 
        //add to cart and display it in DOM
        const cartItem = {id, name, price, photo, quantity: 1};
        cart = [...cart, cartItem];
        addToCartDOM(cartItem);
        displayTotalCartItemQuantity();
        displayAllTotalCost();
        setStorageCart(cart);
   }
   else {
        //increase quantity in local storage and display increased quantity in DOM 
        increaseQuantity(id);
   }
   showCart();
}

// increase quantity of cart item
const increaseQuantity = (id) => {
    let increasedQuantity;
    cart = cart.map(item => {
        if(item.id == id){
            increasedQuantity = item.quantity + 1;
            item = {...item, quantity: increasedQuantity};
        }
        return item;
    });
    const quantityElAll = [...document.querySelectorAll(".cart-item-quantity")];
    const quantityEl = quantityElAll.find(item => item.dataset.id == id); 
    quantityEl.textContent = increasedQuantity;
    setStorageCart(cart);
    displayTotalCartItemQuantity();
    displayAllTotalCost();
}

// decrease quantity of cart item
const decreaseQuantity = (id) => {
    const quantityElAll = [...document.querySelectorAll(".cart-item-quantity")];
    const quantityEl = quantityElAll.find(item => item.dataset.id == id); 
    let decreasedQuantity;

    cart = cart.map(item => {
        if(item.id == id){
            decreasedQuantity = item.quantity - 1;
            item = {...item, quantity: decreasedQuantity};
        }
        return item;
    });

    if(decreasedQuantity <= 0) {
        cart = cart.filter((cartItem) => cartItem.quantity !== 0);
        quantityEl.parentElement.parentElement.remove();
    }
    else {
        quantityEl.textContent = decreasedQuantity;
    }
    setStorageCart(cart);
    displayTotalCartItemQuantity();
    displayAllTotalCost();
}

// remove cart item
cartItemsEl.addEventListener("click", (e) => {
    if(e.target.parentElement.classList.contains("btn-remove-cart-item") || e.target.classList.contains("btn-remove-cart-item")){
        let id;
        if(e.target.dataset.id){
            id = e.target.dataset.id;
            e.target.parentElement.parentElement.remove();
        }
        else {
            id = e.target.parentElement.dataset.id
            e.target.parentElement.parentElement.parentElement.remove();
        }
        cart = cart.filter((cartItem) => cartItem.id !== id);
        setStorageCart(cart);
    }
    displayTotalCartItemQuantity();
    displayAllTotalCost();
});

// display all cart items to DOM
const displayCartItem = () => {
    cart.forEach((cartItem) => {
    addToCartDOM(cartItem);
    });
    displayTotalCartItemQuantity();
    displayShippingCost();
    displayAllTotalCost();
}

const orderSection = document.querySelector(".order-section");

// display cart in client side pages
window.addEventListener("DOMContentLoaded", () => {
    if(cartOverlay) {
        displayCartItem();
    }
});


const placeOrder = () => {
    const orderForm = document.querySelector(".order-form");
    const shippingAddress = orderForm.shipping_address.value;
    const phone = orderForm.phone.value;
    const paymentMethod = orderForm.payment_method.value;

    const totalCost = cart.reduce((total, item)=> (total + item.quantity * item.price),0) + shippingCost;
    if(totalCost == 100) {
        showToastMessage("cart is empty!","error");
        return;
    }
    const productIdList = cart.map(item => item.id);
    const quantityList = cart.map(item => item.quantity);

    const url = `/orderservlet?action=order&shipping_address=${shippingAddress}&phone=${phone}&payment_method=${paymentMethod}&productid_list=${productIdList}&quantity_list=${quantityList}&total_cost=${totalCost}`;
    localStorage.removeItem("nepshop");
    window.location.href = url;
}
