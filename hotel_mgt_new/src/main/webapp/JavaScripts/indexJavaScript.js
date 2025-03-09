document.addEventListener("DOMContentLoaded", () => {
    // Fade-in animation on scroll
    const fadeElements = document.querySelectorAll(".room");
    
    const observer = new IntersectionObserver(entries => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add("fade-in");
            }
        });
    }, { threshold: 0.2 });
    
    fadeElements.forEach(el => observer.observe(el));
    
    // Smooth scrolling for navigation links
    document.querySelectorAll("nav ul li a").forEach(anchor => {
        anchor.addEventListener("click", function(e) {
            e.preventDefault();
            const targetId = this.getAttribute("href").substring(1);
            const targetElement = document.getElementById(targetId);
            
            if (targetElement) {
                window.scrollTo({
                    top: targetElement.offsetTop - 50,
                    behavior: "smooth"
                });
            }
        });
    });
    
    // Button hover animation
    const bookButton = document.querySelector(".hero button");
    if (bookButton) {
        bookButton.addEventListener("mouseover", () => {
            bookButton.style.transform = "scale(1.1)";
        });
        bookButton.addEventListener("mouseout", () => {
            bookButton.style.transform = "scale(1)";
        });
    }
});
