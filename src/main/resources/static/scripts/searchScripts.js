const selector = document.querySelector('.category-btn');

selector.addEventListener("change", () => {

    let searchForm = document.querySelector('.header-search-form');
    let selectedValue = selector.options[selector.selectedIndex].innerText;

    if (selectedValue === 'Stickers') {
        searchForm.action = "/stickers/list";
    } else {
        searchForm.action = "/posters/list";
    }
});