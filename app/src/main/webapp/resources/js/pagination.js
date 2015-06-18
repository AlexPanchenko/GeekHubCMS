function Pagination(options) {
    this.itemsCount = options.itemsCount;
    this.limit = options.limit || 15;
    this.maxSize = options.maxSize || 5;
    this.currentPage = options.currentPage;
    this.url = options.url;
    this.pagesCount = Math.ceil(this.itemsCount / this.limit);
    this.prevPage = 0;

    this.showNewPage = function (page) {
        this.currentPage = page;
        $.ajax({
            url: this.url,
            data: {page: page},
            success: function (data) {
                $("#rows").html(data);
            }
        });
        this.render();
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

    this.firstPage = function () {
        this.showNewPage(1);
    };
    this.lastPage = function () {
        this.showNewPage(this.pagesCount);
    };

    this.render = function () {
        $(".page-number").remove();
        var paginationList = $("#next-page").parent();
        var start, finish;
        var center = Math.floor(this.maxSize/2);
        var currentPage = parseInt(this.currentPage);
        if((currentPage + center) >= this.pagesCount){
            start = this.pagesCount - this.maxSize + 1;
            finish = this.pagesCount;
        }
         else if(currentPage <= center){
            start = 1;
            finish = this.maxSize;
        } else{
            start = currentPage - center;
            finish = currentPage + center;
        }

        for (start; start <= finish; start++) {
            var li = $("<li/>").insertBefore(items);
            $('<a/>', {
                id: 'page' + start,
                href: '#',
                class: "page-number",
                text: start
            }).appendTo(li);
        }
    }
}
