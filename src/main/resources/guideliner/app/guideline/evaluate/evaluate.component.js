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
var core_2 = require('@angular/core');
var components_helper_service_1 = require('ng2-bootstrap/components/utils/components-helper.service');
var usability_service_1 = require("../shared/usability.service");
var evaluation_dto_1 = require("../../shared/evaluation.dto");
var GuidelineEvaluateComponent = (function () {
    function GuidelineEvaluateComponent(http, componentsHelper, vcr, usabilityService) {
        this.http = http;
        this.componentsHelper = componentsHelper;
        this.vcr = vcr;
        this.usabilityService = usabilityService;
        this.results = new Array();
        this.loading = true;
        this.summary = [];
        componentsHelper.setRootViewContainerRef(vcr);
    }
    GuidelineEvaluateComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.get().subscribe(function (results) {
            _this.results = results;
            _this.loading = false;
            _this.summary = _this.calculateSummary(_this.results);
        });
    };
    GuidelineEvaluateComponent.prototype.get = function () {
        return this.usabilityService.evaluateByCategory(this.category.category, this.category.url);
    };
    GuidelineEvaluateComponent.prototype.calculateSummary = function (results) {
        var amountOfFailed = 0;
        var amountOfSuccess = 0;
        amountOfFailed = results.filter(function (res) { return res.result == "FAIL"; }).length;
        amountOfSuccess = results.filter(function (res) { return res.result == "SUCCESS"; }).length;
        this.summary = [];
        this.summary.push({
            value: 100 * amountOfFailed / (amountOfFailed + amountOfSuccess),
            type: 'danger'
        });
        this.summary.push({
            value: 100 * amountOfSuccess / (amountOfFailed + amountOfSuccess),
            type: 'success'
        });
        return this.summary;
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', evaluation_dto_1.CategoryEvaluation)
    ], GuidelineEvaluateComponent.prototype, "category", void 0);
    GuidelineEvaluateComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'guideline-evaluate',
            templateUrl: 'evaluate.component.html',
            providers: [],
            pipes: []
        }), 
        __metadata('design:paramtypes', [http_1.Http, components_helper_service_1.ComponentsHelper, core_2.ViewContainerRef, usability_service_1.UsabilityService])
    ], GuidelineEvaluateComponent);
    return GuidelineEvaluateComponent;
}());
exports.GuidelineEvaluateComponent = GuidelineEvaluateComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvZXZhbHVhdGUvZXZhbHVhdGUuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBa0QsZUFBZSxDQUFDLENBQUE7QUFJbEUscUJBQW1CLGVBQWUsQ0FBQyxDQUFBO0FBQ25DLHFCQUFpQyxlQUFlLENBQUMsQ0FBQTtBQUNqRCwwQ0FBaUMsMERBQTBELENBQUMsQ0FBQTtBQUM1RixrQ0FBK0IsNkJBQTZCLENBQUMsQ0FBQTtBQUM3RCwrQkFBaUMsNkJBQTZCLENBQUMsQ0FBQTtBQVMvRDtJQVVFLG9DQUFvQixJQUFTLEVBQVUsZ0JBQWtDLEVBQVUsR0FBcUIsRUFBVSxnQkFBaUM7UUFBL0gsU0FBSSxHQUFKLElBQUksQ0FBSztRQUFVLHFCQUFnQixHQUFoQixnQkFBZ0IsQ0FBa0I7UUFBVSxRQUFHLEdBQUgsR0FBRyxDQUFrQjtRQUFVLHFCQUFnQixHQUFoQixnQkFBZ0IsQ0FBaUI7UUFSNUksWUFBTyxHQUEyQixJQUFJLEtBQUssRUFBb0IsQ0FBQztRQUVoRSxZQUFPLEdBQVksSUFBSSxDQUFDO1FBSXhCLFlBQU8sR0FBUyxFQUFFLENBQUM7UUFHeEIsZ0JBQWdCLENBQUMsdUJBQXVCLENBQUMsR0FBRyxDQUFDLENBQUM7SUFDaEQsQ0FBQztJQUVELDZDQUFRLEdBQVI7UUFBQSxpQkFNQztRQUxDLElBQUksQ0FBQyxHQUFHLEVBQUUsQ0FBQyxTQUFTLENBQUMsVUFBQSxPQUFPO1lBQzFCLEtBQUksQ0FBQyxPQUFPLEdBQUcsT0FBTyxDQUFDO1lBQ3ZCLEtBQUksQ0FBQyxPQUFPLEdBQUcsS0FBSyxDQUFDO1lBQ3JCLEtBQUksQ0FBQyxPQUFPLEdBQUcsS0FBSSxDQUFDLGdCQUFnQixDQUFDLEtBQUksQ0FBQyxPQUFPLENBQUMsQ0FBQztRQUNyRCxDQUFDLENBQUMsQ0FBQTtJQUNKLENBQUM7SUFFRCx3Q0FBRyxHQUFIO1FBQ0UsTUFBTSxDQUFDLElBQUksQ0FBQyxnQkFBZ0IsQ0FBQyxrQkFBa0IsQ0FBQyxJQUFJLENBQUMsUUFBUSxDQUFDLFFBQVEsRUFBRSxJQUFJLENBQUMsUUFBUSxDQUFDLEdBQUcsQ0FBQyxDQUFDO0lBQzdGLENBQUM7SUFFTyxxREFBZ0IsR0FBeEIsVUFBeUIsT0FBZ0M7UUFDdkQsSUFBSSxjQUFjLEdBQVksQ0FBQyxDQUFBO1FBQy9CLElBQUksZUFBZSxHQUFZLENBQUMsQ0FBQztRQUNqQyxjQUFjLEdBQUcsT0FBTyxDQUFDLE1BQU0sQ0FBQyxVQUFBLEdBQUcsSUFBSSxPQUFBLEdBQUcsQ0FBQyxNQUFNLElBQUksTUFBTSxFQUFwQixDQUFvQixDQUFDLENBQUMsTUFBTSxDQUFDO1FBQ3BFLGVBQWUsR0FBRyxPQUFPLENBQUMsTUFBTSxDQUFDLFVBQUEsR0FBRyxJQUFJLE9BQUEsR0FBRyxDQUFDLE1BQU0sSUFBSSxTQUFTLEVBQXZCLENBQXVCLENBQUMsQ0FBQyxNQUFNLENBQUM7UUFFeEUsSUFBSSxDQUFDLE9BQU8sR0FBRyxFQUFFLENBQUM7UUFDbEIsSUFBSSxDQUFDLE9BQU8sQ0FBQyxJQUFJLENBQUM7WUFDaEIsS0FBSyxFQUFFLEdBQUcsR0FBQyxjQUFjLEdBQUMsQ0FBQyxjQUFjLEdBQUcsZUFBZSxDQUFDO1lBQzVELElBQUksRUFBRSxRQUFRO1NBQ2YsQ0FBQyxDQUFDO1FBRUgsSUFBSSxDQUFDLE9BQU8sQ0FBQyxJQUFJLENBQUM7WUFDaEIsS0FBSyxFQUFFLEdBQUcsR0FBQyxlQUFlLEdBQUMsQ0FBQyxjQUFjLEdBQUcsZUFBZSxDQUFDO1lBQzdELElBQUksRUFBRSxTQUFTO1NBQ2hCLENBQUMsQ0FBQztRQUVILE1BQU0sQ0FBQyxJQUFJLENBQUMsT0FBTyxDQUFDO0lBQ3RCLENBQUM7SUF0Q0Q7UUFBQyxZQUFLLEVBQUU7O2dFQUFBO0lBYlY7UUFBQyxnQkFBUyxDQUFDO1lBQ1QsUUFBUSxFQUFFLE1BQU0sQ0FBQyxFQUFFO1lBQ25CLFFBQVEsRUFBRSxvQkFBb0I7WUFDOUIsV0FBVyxFQUFFLHlCQUF5QjtZQUN0QyxTQUFTLEVBQUUsRUFBRTtZQUNiLEtBQUssRUFBRSxFQUFFO1NBQ1YsQ0FBQzs7a0NBQUE7SUErQ0YsaUNBQUM7QUFBRCxDQTlDQSxBQThDQyxJQUFBO0FBOUNZLGtDQUEwQiw2QkE4Q3RDLENBQUEiLCJmaWxlIjoiYXBwL2d1aWRlbGluZS9ldmFsdWF0ZS9ldmFsdWF0ZS5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudCwgT25Jbml0LCBWaWV3Q2hpbGQsIElucHV0fSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHtNb2RhbERpcmVjdGl2ZX0gZnJvbSBcIm5nMi1ib290c3RyYXAvY29tcG9uZW50cy9tb2RhbC9tb2RhbC5jb21wb25lbnRcIjtcclxuaW1wb3J0IHtFdmFsdWF0aW9uUmVzdWx0fSBmcm9tIFwiLi4vLi4vZ3VpZGVsaW5lLnZpZXcvZ3VpZGVsaW5lXCI7XHJcbmltcG9ydCB7T2JzZXJ2YWJsZX0gZnJvbSBcInJ4anNcIjtcclxuaW1wb3J0IHtIdHRwfSBmcm9tIFwiQGFuZ3VsYXIvaHR0cFwiO1xyXG5pbXBvcnQgeyBWaWV3Q29udGFpbmVyUmVmIH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XHJcbmltcG9ydCB7IENvbXBvbmVudHNIZWxwZXIgfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvdXRpbHMvY29tcG9uZW50cy1oZWxwZXIuc2VydmljZSc7XHJcbmltcG9ydCB7VXNhYmlsaXR5U2VydmljZX0gZnJvbSBcIi4uL3NoYXJlZC91c2FiaWxpdHkuc2VydmljZVwiO1xyXG5pbXBvcnQge0NhdGVnb3J5RXZhbHVhdGlvbn0gZnJvbSBcIi4uLy4uL3NoYXJlZC9ldmFsdWF0aW9uLmR0b1wiO1xyXG5cclxuQENvbXBvbmVudCh7XHJcbiAgbW9kdWxlSWQ6IG1vZHVsZS5pZCxcclxuICBzZWxlY3RvcjogJ2d1aWRlbGluZS1ldmFsdWF0ZScsXHJcbiAgdGVtcGxhdGVVcmw6ICdldmFsdWF0ZS5jb21wb25lbnQuaHRtbCcsXHJcbiAgcHJvdmlkZXJzOiBbXSxcclxuICBwaXBlczogW11cclxufSlcclxuZXhwb3J0IGNsYXNzIEd1aWRlbGluZUV2YWx1YXRlQ29tcG9uZW50IGltcGxlbWVudHMgT25Jbml0IHtcclxuXHJcbiAgcHVibGljIHJlc3VsdHM6QXJyYXk8RXZhbHVhdGlvblJlc3VsdD4gPSBuZXcgQXJyYXk8RXZhbHVhdGlvblJlc3VsdD4oKTtcclxuXHJcbiAgcHVibGljIGxvYWRpbmc6IGJvb2xlYW4gPSB0cnVlO1xyXG5cclxuICBASW5wdXQoKSBjYXRlZ29yeTpDYXRlZ29yeUV2YWx1YXRpb247XHJcblxyXG4gIHB1YmxpYyBzdW1tYXJ5OmFueVtdID0gW107XHJcblxyXG4gIGNvbnN0cnVjdG9yKHByaXZhdGUgaHR0cDpIdHRwLCBwcml2YXRlIGNvbXBvbmVudHNIZWxwZXI6IENvbXBvbmVudHNIZWxwZXIsIHByaXZhdGUgdmNyOiBWaWV3Q29udGFpbmVyUmVmLCBwcml2YXRlIHVzYWJpbGl0eVNlcnZpY2U6VXNhYmlsaXR5U2VydmljZSkge1xyXG4gICAgY29tcG9uZW50c0hlbHBlci5zZXRSb290Vmlld0NvbnRhaW5lclJlZih2Y3IpO1xyXG4gIH1cclxuXHJcbiAgbmdPbkluaXQoKTogdm9pZCB7XHJcbiAgICB0aGlzLmdldCgpLnN1YnNjcmliZShyZXN1bHRzID0+IHtcclxuICAgICAgdGhpcy5yZXN1bHRzID0gcmVzdWx0cztcclxuICAgICAgdGhpcy5sb2FkaW5nID0gZmFsc2U7XHJcbiAgICAgIHRoaXMuc3VtbWFyeSA9IHRoaXMuY2FsY3VsYXRlU3VtbWFyeSh0aGlzLnJlc3VsdHMpO1xyXG4gICAgfSlcclxuICB9XHJcblxyXG4gIGdldCgpOk9ic2VydmFibGU8YW55PiB7XHJcbiAgICByZXR1cm4gdGhpcy51c2FiaWxpdHlTZXJ2aWNlLmV2YWx1YXRlQnlDYXRlZ29yeSh0aGlzLmNhdGVnb3J5LmNhdGVnb3J5LCB0aGlzLmNhdGVnb3J5LnVybCk7XHJcbiAgfVxyXG5cclxuICBwcml2YXRlIGNhbGN1bGF0ZVN1bW1hcnkocmVzdWx0czogQXJyYXk8RXZhbHVhdGlvblJlc3VsdD4pIDogYW55W10ge1xyXG4gICAgbGV0IGFtb3VudE9mRmFpbGVkIDogbnVtYmVyID0gMFxyXG4gICAgbGV0IGFtb3VudE9mU3VjY2VzcyA6IG51bWJlciA9IDA7XHJcbiAgICBhbW91bnRPZkZhaWxlZCA9IHJlc3VsdHMuZmlsdGVyKHJlcyA9PiByZXMucmVzdWx0ID09IFwiRkFJTFwiKS5sZW5ndGg7XHJcbiAgICBhbW91bnRPZlN1Y2Nlc3MgPSByZXN1bHRzLmZpbHRlcihyZXMgPT4gcmVzLnJlc3VsdCA9PSBcIlNVQ0NFU1NcIikubGVuZ3RoO1xyXG5cclxuICAgIHRoaXMuc3VtbWFyeSA9IFtdO1xyXG4gICAgdGhpcy5zdW1tYXJ5LnB1c2goe1xyXG4gICAgICB2YWx1ZTogMTAwKmFtb3VudE9mRmFpbGVkLyhhbW91bnRPZkZhaWxlZCArIGFtb3VudE9mU3VjY2VzcyksXHJcbiAgICAgIHR5cGU6ICdkYW5nZXInXHJcbiAgICB9KTtcclxuXHJcbiAgICB0aGlzLnN1bW1hcnkucHVzaCh7XHJcbiAgICAgIHZhbHVlOiAxMDAqYW1vdW50T2ZTdWNjZXNzLyhhbW91bnRPZkZhaWxlZCArIGFtb3VudE9mU3VjY2VzcyksXHJcbiAgICAgIHR5cGU6ICdzdWNjZXNzJ1xyXG4gICAgfSk7XHJcblxyXG4gICAgcmV0dXJuIHRoaXMuc3VtbWFyeTtcclxuICB9XHJcblxyXG59XHJcbiJdfQ==
