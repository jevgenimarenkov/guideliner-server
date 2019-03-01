"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var http_1 = require("@angular/http");
var section_service_1 = require("../layout.content.section/section.service");
var evaluation_dto_1 = require("../shared/evaluation.dto");
var SelectCategoriesComponent = (function () {
    function SelectCategoriesComponent(http, sectionService) {
        this.http = http;
        this.sectionService = sectionService;
        this.categories = new Array();
        this.guidelines = [];
        this.selectedCategory = '';
        this.webURL = "http://www.etis.ee";
    }
    SelectCategoriesComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.retrieveGuidelineCategoreis().subscribe(function (c) {
            _this.categories = c;
            _this.showCategories(c[0]);
        });
    };
    SelectCategoriesComponent.prototype.retrieveGuidelineCategoreis = function () {
        var url = "http://localhost:8080/usability/categories";
        return this.http.get(url).map(function (resp) { return resp.json(); });
    };
    SelectCategoriesComponent.prototype.showCategories = function (category) {
        var _this = this;
        this.selectedCategory = category;
        console.log(category);
        this.get(category).subscribe(function (guidelines) {
            _this.guidelines = guidelines;
        });
    };
    SelectCategoriesComponent.prototype.performEvaluation = function () {
        var categoryEvaluation = new evaluation_dto_1.CategoryEvaluation();
        categoryEvaluation.category = this.selectedCategory;
        categoryEvaluation.url = this.webURL;
        this.sectionService.leftSection.openGuidelineAutoEvaluationResultsTab(categoryEvaluation);
    };
    SelectCategoriesComponent.prototype.get = function (category) {
        var url = "http://localhost:8080/usability/categories/" + category;
        return this.http.get(url).map(function (resp) { return resp.json(); });
    };
    SelectCategoriesComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'guideline-categories',
            templateUrl: 'select-categories.component.html'
        }), 
        __metadata('design:paramtypes', [http_1.Http, section_service_1.SectionService])
    ], SelectCategoriesComponent);
    return SelectCategoriesComponent;
}());
exports.SelectCategoriesComponent = SelectCategoriesComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUuc2VsZWN0LWNhdGVnb3JpZXMvc2VsZWN0LWNhdGVnb3JpZXMuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBZ0MsZUFBZSxDQUFDLENBQUE7QUFFaEQscUJBQW1CLGVBQWUsQ0FBQyxDQUFBO0FBQ25DLGdDQUE2QiwyQ0FBMkMsQ0FBQyxDQUFBO0FBRXpFLCtCQUFpQywwQkFBMEIsQ0FBQyxDQUFBO0FBTzVEO0lBVUUsbUNBQW9CLElBQVMsRUFBVSxjQUE2QjtRQUFoRCxTQUFJLEdBQUosSUFBSSxDQUFLO1FBQVUsbUJBQWMsR0FBZCxjQUFjLENBQWU7UUFSN0QsZUFBVSxHQUFpQixJQUFJLEtBQUssRUFBVSxDQUFDO1FBRS9DLGVBQVUsR0FBb0IsRUFBRSxDQUFDO1FBRWpDLHFCQUFnQixHQUFVLEVBQUUsQ0FBQztRQUU3QixXQUFNLEdBQVksb0JBQW9CLENBQUM7SUFJOUMsQ0FBQztJQUVELDRDQUFRLEdBQVI7UUFBQSxpQkFNQztRQUxDLElBQUksQ0FBQywyQkFBMkIsRUFBRSxDQUFDLFNBQVMsQ0FBQyxVQUFBLENBQUM7WUFDNUMsS0FBSSxDQUFDLFVBQVUsR0FBRyxDQUFDLENBQUM7WUFDcEIsS0FBSSxDQUFDLGNBQWMsQ0FBQyxDQUFDLENBQUMsQ0FBQyxDQUFDLENBQUMsQ0FBQztRQUM1QixDQUFDLENBQUMsQ0FBQTtJQUVKLENBQUM7SUFFRCwrREFBMkIsR0FBM0I7UUFDRSxJQUFJLEdBQUcsR0FBVSw0Q0FBNEMsQ0FBQztRQUM5RCxNQUFNLENBQUMsSUFBSSxDQUFDLElBQUksQ0FBQyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUMsR0FBRyxDQUFDLFVBQUEsSUFBSSxJQUFJLE9BQUEsSUFBSSxDQUFDLElBQUksRUFBRSxFQUFYLENBQVcsQ0FBQyxDQUFDO0lBQ3JELENBQUM7SUFFRCxrREFBYyxHQUFkLFVBQWUsUUFBUTtRQUF2QixpQkFPQztRQU5DLElBQUksQ0FBQyxnQkFBZ0IsR0FBRyxRQUFRLENBQUM7UUFDakMsT0FBTyxDQUFDLEdBQUcsQ0FBQyxRQUFRLENBQUMsQ0FBQztRQUV0QixJQUFJLENBQUMsR0FBRyxDQUFDLFFBQVEsQ0FBQyxDQUFDLFNBQVMsQ0FBQyxVQUFBLFVBQVU7WUFDckMsS0FBSSxDQUFDLFVBQVUsR0FBRyxVQUFVLENBQUM7UUFDL0IsQ0FBQyxDQUFDLENBQUM7SUFDTCxDQUFDO0lBRUQscURBQWlCLEdBQWpCO1FBQ0UsSUFBSSxrQkFBa0IsR0FBd0IsSUFBSSxtQ0FBa0IsRUFBRSxDQUFDO1FBQ3ZFLGtCQUFrQixDQUFDLFFBQVEsR0FBRyxJQUFJLENBQUMsZ0JBQWdCLENBQUM7UUFDcEQsa0JBQWtCLENBQUMsR0FBRyxHQUFHLElBQUksQ0FBQyxNQUFNLENBQUM7UUFFckMsSUFBSSxDQUFDLGNBQWMsQ0FBQyxXQUFXLENBQUMscUNBQXFDLENBQUMsa0JBQWtCLENBQUMsQ0FBQztJQUM1RixDQUFDO0lBRUQsdUNBQUcsR0FBSCxVQUFJLFFBQWlCO1FBQ25CLElBQUksR0FBRyxHQUFVLDZDQUE2QyxHQUFHLFFBQVEsQ0FBQztRQUMxRSxNQUFNLENBQUMsSUFBSSxDQUFDLElBQUksQ0FBQyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUMsR0FBRyxDQUFDLFVBQUEsSUFBSSxJQUFJLE9BQUEsSUFBSSxDQUFDLElBQUksRUFBRSxFQUFYLENBQVcsQ0FBQyxDQUFDO0lBQ3JELENBQUM7SUFwREg7UUFBQyxnQkFBUyxDQUFDO1lBQ1QsUUFBUSxFQUFFLE1BQU0sQ0FBQyxFQUFFO1lBQ25CLFFBQVEsRUFBRSxzQkFBc0I7WUFDaEMsV0FBVyxFQUFFLGtDQUFrQztTQUNoRCxDQUFDOztpQ0FBQTtJQWtERixnQ0FBQztBQUFELENBakRBLEFBaURDLElBQUE7QUFqRFksaUNBQXlCLDRCQWlEckMsQ0FBQSIsImZpbGUiOiJhcHAvZ3VpZGVsaW5lLnNlbGVjdC1jYXRlZ29yaWVzL3NlbGVjdC1jYXRlZ29yaWVzLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBPbkluaXR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge09ic2VydmFibGV9IGZyb20gXCJyeGpzXCI7XHJcbmltcG9ydCB7SHR0cH0gZnJvbSBcIkBhbmd1bGFyL2h0dHBcIjtcclxuaW1wb3J0IHtTZWN0aW9uU2VydmljZX0gZnJvbSBcIi4uL2xheW91dC5jb250ZW50LnNlY3Rpb24vc2VjdGlvbi5zZXJ2aWNlXCI7XHJcbmltcG9ydCB7R3VpZGVsaW5lfSBmcm9tIFwiLi4vZ3VpZGVsaW5lLnZpZXcvZ3VpZGVsaW5lXCI7XHJcbmltcG9ydCB7Q2F0ZWdvcnlFdmFsdWF0aW9ufSBmcm9tIFwiLi4vc2hhcmVkL2V2YWx1YXRpb24uZHRvXCI7XHJcblxyXG5AQ29tcG9uZW50KHtcclxuICBtb2R1bGVJZDogbW9kdWxlLmlkLFxyXG4gIHNlbGVjdG9yOiAnZ3VpZGVsaW5lLWNhdGVnb3JpZXMnLFxyXG4gIHRlbXBsYXRlVXJsOiAnc2VsZWN0LWNhdGVnb3JpZXMuY29tcG9uZW50Lmh0bWwnXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBTZWxlY3RDYXRlZ29yaWVzQ29tcG9uZW50IGltcGxlbWVudHMgT25Jbml0IHtcclxuXHJcbiAgcHVibGljIGNhdGVnb3JpZXM6QXJyYXk8U3RyaW5nPiA9IG5ldyBBcnJheTxTdHJpbmc+KCk7XHJcblxyXG4gIHB1YmxpYyBndWlkZWxpbmVzOkFycmF5PEd1aWRlbGluZT4gPSBbXTtcclxuXHJcbiAgcHVibGljIHNlbGVjdGVkQ2F0ZWdvcnk6c3RyaW5nID0gJyc7XHJcblxyXG4gIHB1YmxpYyB3ZWJVUkwgOiBTdHJpbmcgPSBcImh0dHA6Ly93d3cuZXRpcy5lZVwiO1xyXG5cclxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIGh0dHA6SHR0cCwgcHJpdmF0ZSBzZWN0aW9uU2VydmljZTpTZWN0aW9uU2VydmljZSkge1xyXG5cclxuICB9XHJcblxyXG4gIG5nT25Jbml0KCk6IHZvaWQge1xyXG4gICAgdGhpcy5yZXRyaWV2ZUd1aWRlbGluZUNhdGVnb3JlaXMoKS5zdWJzY3JpYmUoYyA9PiB7XHJcbiAgICAgIHRoaXMuY2F0ZWdvcmllcyA9IGM7XHJcbiAgICAgIHRoaXMuc2hvd0NhdGVnb3JpZXMoY1swXSk7XHJcbiAgICB9KVxyXG5cclxuICB9XHJcblxyXG4gIHJldHJpZXZlR3VpZGVsaW5lQ2F0ZWdvcmVpcygpOk9ic2VydmFibGU8YW55PiB7XHJcbiAgICBsZXQgdXJsOnN0cmluZyA9IGBodHRwOi8vbG9jYWxob3N0OjgwODAvdXNhYmlsaXR5L2NhdGVnb3JpZXNgO1xyXG4gICAgcmV0dXJuIHRoaXMuaHR0cC5nZXQodXJsKS5tYXAocmVzcCA9PiByZXNwLmpzb24oKSk7XHJcbiAgfVxyXG5cclxuICBzaG93Q2F0ZWdvcmllcyhjYXRlZ29yeSk6dm9pZCB7XHJcbiAgICB0aGlzLnNlbGVjdGVkQ2F0ZWdvcnkgPSBjYXRlZ29yeTtcclxuICAgIGNvbnNvbGUubG9nKGNhdGVnb3J5KTtcclxuXHJcbiAgICB0aGlzLmdldChjYXRlZ29yeSkuc3Vic2NyaWJlKGd1aWRlbGluZXMgPT4ge1xyXG4gICAgICB0aGlzLmd1aWRlbGluZXMgPSBndWlkZWxpbmVzO1xyXG4gICAgfSk7XHJcbiAgfVxyXG5cclxuICBwZXJmb3JtRXZhbHVhdGlvbigpOnZvaWQge1xyXG4gICAgbGV0IGNhdGVnb3J5RXZhbHVhdGlvbiA6IENhdGVnb3J5RXZhbHVhdGlvbiA9IG5ldyBDYXRlZ29yeUV2YWx1YXRpb24oKTtcclxuICAgIGNhdGVnb3J5RXZhbHVhdGlvbi5jYXRlZ29yeSA9IHRoaXMuc2VsZWN0ZWRDYXRlZ29yeTtcclxuICAgIGNhdGVnb3J5RXZhbHVhdGlvbi51cmwgPSB0aGlzLndlYlVSTDtcclxuXHJcbiAgICB0aGlzLnNlY3Rpb25TZXJ2aWNlLmxlZnRTZWN0aW9uLm9wZW5HdWlkZWxpbmVBdXRvRXZhbHVhdGlvblJlc3VsdHNUYWIoY2F0ZWdvcnlFdmFsdWF0aW9uKTtcclxuICB9XHJcblxyXG4gIGdldChjYXRlZ29yeSA6IFN0cmluZyk6T2JzZXJ2YWJsZTxhbnk+IHtcclxuICAgIGxldCB1cmw6c3RyaW5nID0gYGh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC91c2FiaWxpdHkvY2F0ZWdvcmllcy9gICsgY2F0ZWdvcnk7XHJcbiAgICByZXR1cm4gdGhpcy5odHRwLmdldCh1cmwpLm1hcChyZXNwID0+IHJlc3AuanNvbigpKTtcclxuICB9XHJcblxyXG59XHJcbiJdfQ==
