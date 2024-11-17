document.addEventListener("DOMContentLoaded", function () {
    const swiper = new Swiper(".swiper", {
      loop: true, // Hace el slider infinito
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
      autoplay: {
        delay: 5000, // Cambia de diapositiva cada 3 segundos
        disableOnInteraction: false,
      },
    });
  });