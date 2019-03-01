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
var section_service_1 = require("../../layout.content.section/section.service");
var evaluation_dto_1 = require("../../shared/evaluation.dto");
var usability_service_1 = require("../shared/usability.service");
var CategorisedGuidelinesComponent = (function () {
    function CategorisedGuidelinesComponent(http, sectionService, usabilityService) {
        this.http = http;
        this.sectionService = sectionService;
        this.usabilityService = usabilityService;
        this.categories = new Array();
        this.guidelines = [];
        this.selectedCategory = '';
        this.webURL = "http://www.etis.ee";
    }
    CategorisedGuidelinesComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.usabilityService.getUsabilityCategory().subscribe(function (c) {
            _this.categories = c;
            _this.showCategories(c[0]);
        });
    };
    CategorisedGuidelinesComponent.prototype.showCategories = function (category) {
        var _this = this;
        this.selectedCategory = category;
        this.usabilityService.getUsabilityGuidelinesByCategory(category).subscribe(function (guidelines) {
            _this.guidelines = guidelines;
        });
    };
    CategorisedGuidelinesComponent.prototype.performEvaluation = function () {
        var categoryEvaluation = new evaluation_dto_1.CategoryEvaluation();
        categoryEvaluation.category = this.selectedCategory;
        categoryEvaluation.url = this.webURL;
        this.sectionService.leftSection.openGuidelineAutoEvaluationResultsTab(categoryEvaluation);
    };
    CategorisedGuidelinesComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'categorised-guideline',
            templateUrl: 'categorised-guideline.component.html'
        }), 
        __metadata('design:paramtypes', [http_1.Http, section_service_1.SectionService, usability_service_1.UsabilityService])
    ], CategorisedGuidelinesComponent);
    return CategorisedGuidelinesComponent;
}());
exports.CategorisedGuidelinesComponent = CategorisedGuidelinesComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvY2F0ZWdvcmlzZWQtZ3VpZGVsaW5lL2NhdGVnb3Jpc2VkLWd1aWRlbGluZS5jb21wb25lbnQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7OztBQUFBLHFCQUFnQyxlQUFlLENBQUMsQ0FBQTtBQUVoRCxxQkFBbUIsZUFBZSxDQUFDLENBQUE7QUFDbkMsZ0NBQTZCLDhDQUE4QyxDQUFDLENBQUE7QUFFNUUsK0JBQWlDLDZCQUE2QixDQUFDLENBQUE7QUFDL0Qsa0NBQStCLDZCQUE2QixDQUFDLENBQUE7QUFRN0Q7SUFVRSx3Q0FBb0IsSUFBUyxFQUFVLGNBQTZCLEVBQVUsZ0JBQWlDO1FBQTNGLFNBQUksR0FBSixJQUFJLENBQUs7UUFBVSxtQkFBYyxHQUFkLGNBQWMsQ0FBZTtRQUFVLHFCQUFnQixHQUFoQixnQkFBZ0IsQ0FBaUI7UUFSeEcsZUFBVSxHQUFpQixJQUFJLEtBQUssRUFBVSxDQUFDO1FBRS9DLGVBQVUsR0FBb0IsRUFBRSxDQUFDO1FBRWpDLHFCQUFnQixHQUFVLEVBQUUsQ0FBQztRQUU3QixXQUFNLEdBQVksb0JBQW9CLENBQUM7SUFJOUMsQ0FBQztJQUVELGlEQUFRLEdBQVI7UUFBQSxpQkFLQztRQUpDLElBQUksQ0FBQyxnQkFBZ0IsQ0FBQyxvQkFBb0IsRUFBRSxDQUFDLFNBQVMsQ0FBQyxVQUFBLENBQUM7WUFDdEQsS0FBSSxDQUFDLFVBQVUsR0FBRyxDQUFDLENBQUM7WUFDcEIsS0FBSSxDQUFDLGNBQWMsQ0FBQyxDQUFDLENBQUMsQ0FBQyxDQUFDLENBQUMsQ0FBQztRQUM1QixDQUFDLENBQUMsQ0FBQTtJQUNKLENBQUM7SUFFRCx1REFBYyxHQUFkLFVBQWUsUUFBUTtRQUF2QixpQkFNQztRQUxDLElBQUksQ0FBQyxnQkFBZ0IsR0FBRyxRQUFRLENBQUM7UUFFakMsSUFBSSxDQUFDLGdCQUFnQixDQUFDLGdDQUFnQyxDQUFDLFFBQVEsQ0FBQyxDQUFDLFNBQVMsQ0FBQyxVQUFBLFVBQVU7WUFDbkYsS0FBSSxDQUFDLFVBQVUsR0FBRyxVQUFVLENBQUM7UUFDL0IsQ0FBQyxDQUFDLENBQUM7SUFDTCxDQUFDO0lBRUQsMERBQWlCLEdBQWpCO1FBQ0UsSUFBSSxrQkFBa0IsR0FBd0IsSUFBSSxtQ0FBa0IsRUFBRSxDQUFDO1FBQ3ZFLGtCQUFrQixDQUFDLFFBQVEsR0FBRyxJQUFJLENBQUMsZ0JBQWdCLENBQUM7UUFDcEQsa0JBQWtCLENBQUMsR0FBRyxHQUFHLElBQUksQ0FBQyxNQUFNLENBQUM7UUFDckMsSUFBSSxDQUFDLGNBQWMsQ0FBQyxXQUFXLENBQUMscUNBQXFDLENBQUMsa0JBQWtCLENBQUMsQ0FBQztJQUM1RixDQUFDO0lBdkNIO1FBQUMsZ0JBQVMsQ0FBQztZQUNULFFBQVEsRUFBRSxNQUFNLENBQUMsRUFBRTtZQUNuQixRQUFRLEVBQUUsdUJBQXVCO1lBQ2pDLFdBQVcsRUFBRSxzQ0FBc0M7U0FDcEQsQ0FBQzs7c0NBQUE7SUFxQ0YscUNBQUM7QUFBRCxDQXBDQSxBQW9DQyxJQUFBO0FBcENZLHNDQUE4QixpQ0FvQzFDLENBQUEiLCJmaWxlIjoiYXBwL2d1aWRlbGluZS9jYXRlZ29yaXNlZC1ndWlkZWxpbmUvY2F0ZWdvcmlzZWQtZ3VpZGVsaW5lLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBPbkluaXR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge09ic2VydmFibGV9IGZyb20gXCJyeGpzXCI7XHJcbmltcG9ydCB7SHR0cH0gZnJvbSBcIkBhbmd1bGFyL2h0dHBcIjtcclxuaW1wb3J0IHtTZWN0aW9uU2VydmljZX0gZnJvbSBcIi4uLy4uL2xheW91dC5jb250ZW50LnNlY3Rpb24vc2VjdGlvbi5zZXJ2aWNlXCI7XHJcbmltcG9ydCB7R3VpZGVsaW5lfSBmcm9tIFwiLi4vLi4vZ3VpZGVsaW5lLnZpZXcvZ3VpZGVsaW5lXCI7XHJcbmltcG9ydCB7Q2F0ZWdvcnlFdmFsdWF0aW9ufSBmcm9tIFwiLi4vLi4vc2hhcmVkL2V2YWx1YXRpb24uZHRvXCI7XHJcbmltcG9ydCB7VXNhYmlsaXR5U2VydmljZX0gZnJvbSBcIi4uL3NoYXJlZC91c2FiaWxpdHkuc2VydmljZVwiO1xyXG5cclxuXHJcbkBDb21wb25lbnQoe1xyXG4gIG1vZHVsZUlkOiBtb2R1bGUuaWQsXHJcbiAgc2VsZWN0b3I6ICdjYXRlZ29yaXNlZC1ndWlkZWxpbmUnLFxyXG4gIHRlbXBsYXRlVXJsOiAnY2F0ZWdvcmlzZWQtZ3VpZGVsaW5lLmNvbXBvbmVudC5odG1sJ1xyXG59KVxyXG5leHBvcnQgY2xhc3MgQ2F0ZWdvcmlzZWRHdWlkZWxpbmVzQ29tcG9uZW50IGltcGxlbWVudHMgT25Jbml0IHtcclxuXHJcbiAgcHVibGljIGNhdGVnb3JpZXM6QXJyYXk8U3RyaW5nPiA9IG5ldyBBcnJheTxTdHJpbmc+KCk7XHJcblxyXG4gIHB1YmxpYyBndWlkZWxpbmVzOkFycmF5PEd1aWRlbGluZT4gPSBbXTtcclxuXHJcbiAgcHVibGljIHNlbGVjdGVkQ2F0ZWdvcnk6c3RyaW5nID0gJyc7XHJcblxyXG4gIHB1YmxpYyB3ZWJVUkwgOiBTdHJpbmcgPSBcImh0dHA6Ly93d3cuZXRpcy5lZVwiO1xyXG5cclxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIGh0dHA6SHR0cCwgcHJpdmF0ZSBzZWN0aW9uU2VydmljZTpTZWN0aW9uU2VydmljZSwgcHJpdmF0ZSB1c2FiaWxpdHlTZXJ2aWNlOlVzYWJpbGl0eVNlcnZpY2UpIHtcclxuXHJcbiAgfVxyXG5cclxuICBuZ09uSW5pdCgpOiB2b2lkIHtcclxuICAgIHRoaXMudXNhYmlsaXR5U2VydmljZS5nZXRVc2FiaWxpdHlDYXRlZ29yeSgpLnN1YnNjcmliZShjID0+IHtcclxuICAgICAgdGhpcy5jYXRlZ29yaWVzID0gYztcclxuICAgICAgdGhpcy5zaG93Q2F0ZWdvcmllcyhjWzBdKTtcclxuICAgIH0pXHJcbiAgfVxyXG5cclxuICBzaG93Q2F0ZWdvcmllcyhjYXRlZ29yeSk6dm9pZCB7XHJcbiAgICB0aGlzLnNlbGVjdGVkQ2F0ZWdvcnkgPSBjYXRlZ29yeTtcclxuXHJcbiAgICB0aGlzLnVzYWJpbGl0eVNlcnZpY2UuZ2V0VXNhYmlsaXR5R3VpZGVsaW5lc0J5Q2F0ZWdvcnkoY2F0ZWdvcnkpLnN1YnNjcmliZShndWlkZWxpbmVzID0+IHtcclxuICAgICAgdGhpcy5ndWlkZWxpbmVzID0gZ3VpZGVsaW5lcztcclxuICAgIH0pO1xyXG4gIH1cclxuXHJcbiAgcGVyZm9ybUV2YWx1YXRpb24oKTp2b2lkIHtcclxuICAgIGxldCBjYXRlZ29yeUV2YWx1YXRpb24gOiBDYXRlZ29yeUV2YWx1YXRpb24gPSBuZXcgQ2F0ZWdvcnlFdmFsdWF0aW9uKCk7XHJcbiAgICBjYXRlZ29yeUV2YWx1YXRpb24uY2F0ZWdvcnkgPSB0aGlzLnNlbGVjdGVkQ2F0ZWdvcnk7XHJcbiAgICBjYXRlZ29yeUV2YWx1YXRpb24udXJsID0gdGhpcy53ZWJVUkw7XHJcbiAgICB0aGlzLnNlY3Rpb25TZXJ2aWNlLmxlZnRTZWN0aW9uLm9wZW5HdWlkZWxpbmVBdXRvRXZhbHVhdGlvblJlc3VsdHNUYWIoY2F0ZWdvcnlFdmFsdWF0aW9uKTtcclxuICB9XHJcblxyXG59XHJcbiJdfQ==
