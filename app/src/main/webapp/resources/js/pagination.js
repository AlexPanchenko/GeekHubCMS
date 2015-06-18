function Pagination() {
    this.prevPage = 0;
    this.currentPage = 1;
    this.init = function (options) {
        if ((options.itemsCount && options.url) != undefined) {
            this.itemsCount = options.itemsCount;
            this.url = options.url;
            this.limit = options.limit || 15;
            this.maxSize = options.maxSize || 5;
            this.pagesCount = Math.ceil(this.itemsCount / this.limit);
            this.showNewPage(this.currentPage);
            this.addListeners();
        } else console.error("itemCount and url must not be empty!");
    };

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

        $(".disabled").removeClass("disabled");
        if (page == this.pagesCount) {
            $("#last-page").parent().addClass("disabled");
            $("#next-page").parent().addClass("disabled");
        }
        if (page == 1) {
            $("#first-page").parent().addClass("disabled");
            $("#prev-page").parent().addClass("disabled");
        }

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
        var paginationPages = $("#next-page").parent();
        var start, finish;
        var center = Math.floor(this.maxSize / 2);
        var currentPage = parseInt(this.currentPage);
        var max = this.pagesCount >= this.maxSize ? this.maxSize : this.pagesCount;
        if ((currentPage + center) >= this.pagesCount) {
            start = this.pagesCount - max + 1;
            finish = this.pagesCount;
        }
        else if (currentPage <= center) {
            start = 1;
            finish = max;
        } else {
            start = currentPage - center;
            finish = currentPage + center;
        }

        for (start; start <= finish; start++) {
            var li = $("<li/>").insertBefore(paginationPages);
            $('<a/>', {
                id: 'page' + start,
                href: '#',
                class: "page-number",
                text: start
            }).appendTo(li);
        }
    };
    this.addListeners = function () {
        var self = this;
        var paginationContainer = $(".pagination");
        paginationContainer.on("click", ".page-number", function () {
            var page = $(this).attr("id").substr(4);
            self.showNewPage(page)
        });

        paginationContainer.on("click", "#next-page", function () {
            self.nextPage();
        });

        paginationContainer.on("click", "#prev-page", function () {
            self.previousPage();
        });

        paginationContainer.on("click", "#first-page", function () {
            self.firstPage();
        });
        paginationContainer.on("click", "#last-page", function () {
            self.lastPage();
        });
    }
}
