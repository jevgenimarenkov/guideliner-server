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
var GuidelineViewComponent = (function () {
    function GuidelineViewComponent(http, sectionService) {
        this.http = http;
        this.sectionService = sectionService;
        this.guidelines = new Array();
        this.webURL = "http://www.etis.ee";
    }
    GuidelineViewComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.get().subscribe(function (guidelines) {
            _this.guidelines = guidelines;
        });
    };
    GuidelineViewComponent.prototype.get = function () {
        var url = "http://localhost:8080/retrieve";
        return this.http.get(url).map(function (resp) { return resp.json(); });
    };
    GuidelineViewComponent.prototype.performEvaluation = function () {
        console.log("perform evaluation" + this.webURL);
        this.sectionService.leftSection.openGuidelineAutoEvaluationResultsTab(this.webURL);
    };
    GuidelineViewComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'guideline-view',
            templateUrl: 'view.component.html'
        }), 
        __metadata('design:paramtypes', [http_1.Http, section_service_1.SectionService])
    ], GuidelineViewComponent);
    return GuidelineViewComponent;
}());
exports.GuidelineViewComponent = GuidelineViewComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUudmlldy92aWV3LmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQWdDLGVBQWUsQ0FBQyxDQUFBO0FBRWhELHFCQUFtQixlQUFlLENBQUMsQ0FBQTtBQUVuQyxnQ0FBNkIsMkNBQTJDLENBQUMsQ0FBQTtBQU96RTtJQU1FLGdDQUFvQixJQUFTLEVBQVUsY0FBNkI7UUFBaEQsU0FBSSxHQUFKLElBQUksQ0FBSztRQUFVLG1CQUFjLEdBQWQsY0FBYyxDQUFlO1FBSjdELGVBQVUsR0FBb0IsSUFBSSxLQUFLLEVBQWEsQ0FBQztRQUVyRCxXQUFNLEdBQVksb0JBQW9CLENBQUM7SUFHOUMsQ0FBQztJQUVELHlDQUFRLEdBQVI7UUFBQSxpQkFJQztRQUhDLElBQUksQ0FBQyxHQUFHLEVBQUUsQ0FBQyxTQUFTLENBQUMsVUFBQSxVQUFVO1lBQzdCLEtBQUksQ0FBQyxVQUFVLEdBQUcsVUFBVSxDQUFDO1FBQy9CLENBQUMsQ0FBQyxDQUFBO0lBQ0osQ0FBQztJQUVELG9DQUFHLEdBQUg7UUFDRSxJQUFJLEdBQUcsR0FBVSxnQ0FBZ0MsQ0FBQztRQUNsRCxNQUFNLENBQUMsSUFBSSxDQUFDLElBQUksQ0FBQyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUMsR0FBRyxDQUFDLFVBQUEsSUFBSSxJQUFJLE9BQUEsSUFBSSxDQUFDLElBQUksRUFBRSxFQUFYLENBQVcsQ0FBQyxDQUFDO0lBQ3JELENBQUM7SUFFRCxrREFBaUIsR0FBakI7UUFDRSxPQUFPLENBQUMsR0FBRyxDQUFDLG9CQUFvQixHQUFFLElBQUksQ0FBQyxNQUFNLENBQUMsQ0FBQztRQUMvQyxJQUFJLENBQUMsY0FBYyxDQUFDLFdBQVcsQ0FBQyxxQ0FBcUMsQ0FBQyxJQUFJLENBQUMsTUFBTSxDQUFDLENBQUM7SUFDckYsQ0FBQztJQTVCSDtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsTUFBTSxDQUFDLEVBQUU7WUFDbkIsUUFBUSxFQUFFLGdCQUFnQjtZQUMxQixXQUFXLEVBQUUscUJBQXFCO1NBQ25DLENBQUM7OzhCQUFBO0lBMEJGLDZCQUFDO0FBQUQsQ0F6QkEsQUF5QkMsSUFBQTtBQXpCWSw4QkFBc0IseUJBeUJsQyxDQUFBIiwiZmlsZSI6ImFwcC9ndWlkZWxpbmUudmlldy92aWV3LmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBPbkluaXR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge09ic2VydmFibGV9IGZyb20gXCJyeGpzXCI7XHJcbmltcG9ydCB7SHR0cH0gZnJvbSBcIkBhbmd1bGFyL2h0dHBcIjtcclxuaW1wb3J0IHtHdWlkZWxpbmV9IGZyb20gXCIuL2d1aWRlbGluZVwiO1xyXG5pbXBvcnQge1NlY3Rpb25TZXJ2aWNlfSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi9zZWN0aW9uLnNlcnZpY2VcIjtcclxuXHJcbkBDb21wb25lbnQoe1xyXG4gIG1vZHVsZUlkOiBtb2R1bGUuaWQsXHJcbiAgc2VsZWN0b3I6ICdndWlkZWxpbmUtdmlldycsXHJcbiAgdGVtcGxhdGVVcmw6ICd2aWV3LmNvbXBvbmVudC5odG1sJ1xyXG59KVxyXG5leHBvcnQgY2xhc3MgR3VpZGVsaW5lVmlld0NvbXBvbmVudCBpbXBsZW1lbnRzIE9uSW5pdCB7XHJcblxyXG4gIHB1YmxpYyBndWlkZWxpbmVzOkFycmF5PEd1aWRlbGluZT4gPSBuZXcgQXJyYXk8R3VpZGVsaW5lPigpO1xyXG5cclxuICBwdWJsaWMgd2ViVVJMIDogU3RyaW5nID0gXCJodHRwOi8vd3d3LmV0aXMuZWVcIjtcclxuXHJcbiAgY29uc3RydWN0b3IocHJpdmF0ZSBodHRwOkh0dHAsIHByaXZhdGUgc2VjdGlvblNlcnZpY2U6U2VjdGlvblNlcnZpY2UpIHtcclxuICB9XHJcblxyXG4gIG5nT25Jbml0KCk6IHZvaWQge1xyXG4gICAgdGhpcy5nZXQoKS5zdWJzY3JpYmUoZ3VpZGVsaW5lcyA9PiB7XHJcbiAgICAgIHRoaXMuZ3VpZGVsaW5lcyA9IGd1aWRlbGluZXM7XHJcbiAgICB9KVxyXG4gIH1cclxuXHJcbiAgZ2V0KCk6T2JzZXJ2YWJsZTxhbnk+IHtcclxuICAgIGxldCB1cmw6c3RyaW5nID0gYGh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9yZXRyaWV2ZWA7XHJcbiAgICByZXR1cm4gdGhpcy5odHRwLmdldCh1cmwpLm1hcChyZXNwID0+IHJlc3AuanNvbigpKTtcclxuICB9XHJcblxyXG4gIHBlcmZvcm1FdmFsdWF0aW9uKCk6dm9pZCB7XHJcbiAgICBjb25zb2xlLmxvZyhcInBlcmZvcm0gZXZhbHVhdGlvblwiKyB0aGlzLndlYlVSTCk7XHJcbiAgICB0aGlzLnNlY3Rpb25TZXJ2aWNlLmxlZnRTZWN0aW9uLm9wZW5HdWlkZWxpbmVBdXRvRXZhbHVhdGlvblJlc3VsdHNUYWIodGhpcy53ZWJVUkwpO1xyXG4gIH1cclxuXHJcbn1cclxuIl19
