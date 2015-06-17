function Pagination(options) {
    this.itemsCount = options.itemsCount;
    this.limit = options.limit || 15;
    this.currentPage = options.currentPage;
    this.url = options.url;
    this.pagesCount = Math.ceil(this.itemsCount / this.limit);
    this.prevPage = 0;

    this.showNewPage = function (page) {
        this.currentPage = page;
        $.ajax({
            url: url,
            data: {page: page},
            success: function (data) {
                $("#rows").html(data);
            }
        });

        $("#page" + this.prevPage).closest("li").removeClass("active");
        $("#page" + page).closest("li").addClass("active");
        this.prevPage = this.currentPage;
    };
    this.nextPage = function () {
        if (this.currentPage < this.pagesCount) {
            this.showNewPage(++this.currentPage);
        }
    };
    this.previousPage = function () {
        if (this.currentPage > 1) {
            this.showNewPage(--this.currentPage);
        }
    };
}
