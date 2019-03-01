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
var section_component_1 = require("../layout.content.section/section.component");
var section_service_1 = require("../layout.content.section/section.service");
var ContentComponent = (function () {
    function ContentComponent(sectionService) {
        this.sectionService = sectionService;
    }
    ContentComponent.prototype.ngAfterContentInit = function () {
    };
    ContentComponent.prototype.ngAfterViewInit = function () {
        var _this = this;
        this.sectionService.leftSection = this.leftSection;
        this.sectionService.rightSection = this.rightSection;
        setTimeout(function () {
            _this.sectionService.leftSection.openGuidelineSelectCategoriesTab("1");
        }, 1);
    };
    __decorate([
        core_1.ViewChild('leftSection'), 
        __metadata('design:type', section_component_1.SectionComponent)
    ], ContentComponent.prototype, "leftSection", void 0);
    __decorate([
        core_1.ViewChild('rightSection'), 
        __metadata('design:type', section_component_1.SectionComponent)
    ], ContentComponent.prototype, "rightSection", void 0);
    ContentComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'guideline-content',
            templateUrl: 'content.component.html',
            styleUrls: ['content.component.css'],
            providers: [],
            directives: [],
            pipes: []
        }), 
        __metadata('design:paramtypes', [section_service_1.SectionService])
    ], ContentComponent);
    return ContentComponent;
}());
exports.ContentComponent = ContentComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC9jb250ZW50LmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQWtELGVBQWUsQ0FBQyxDQUFBO0FBQ2xFLGtDQUErQiw2Q0FBNkMsQ0FBQyxDQUFBO0FBQzdFLGdDQUE2QiwyQ0FBMkMsQ0FBQyxDQUFBO0FBV3pFO0lBUUUsMEJBQ1UsY0FBNkI7UUFBN0IsbUJBQWMsR0FBZCxjQUFjLENBQWU7SUFDcEMsQ0FBQztJQUVKLDZDQUFrQixHQUFsQjtJQUNBLENBQUM7SUFFRCwwQ0FBZSxHQUFmO1FBQUEsaUJBVUM7UUFUQyxJQUFJLENBQUMsY0FBYyxDQUFDLFdBQVcsR0FBRyxJQUFJLENBQUMsV0FBVyxDQUFDO1FBQ25ELElBQUksQ0FBQyxjQUFjLENBQUMsWUFBWSxHQUFHLElBQUksQ0FBQyxZQUFZLENBQUM7UUFFckQsVUFBVSxDQUFDO1lBSVQsS0FBSSxDQUFDLGNBQWMsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsR0FBRyxDQUFDLENBQUM7UUFDeEUsQ0FBQyxFQUFFLENBQUMsQ0FBQyxDQUFDO0lBQ1IsQ0FBQztJQXZCRDtRQUFDLGdCQUFTLENBQUMsYUFBYSxDQUFDOzt5REFBQTtJQUd6QjtRQUFDLGdCQUFTLENBQUMsY0FBYyxDQUFDOzswREFBQTtJQWQ1QjtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsTUFBTSxDQUFDLEVBQUU7WUFDbkIsUUFBUSxFQUFFLG1CQUFtQjtZQUM3QixXQUFXLEVBQUUsd0JBQXdCO1lBQ3JDLFNBQVMsRUFBRSxDQUFDLHVCQUF1QixDQUFDO1lBQ3BDLFNBQVMsRUFBRSxFQUFFO1lBQ2IsVUFBVSxFQUFFLEVBQUU7WUFDZCxLQUFLLEVBQUUsRUFBRTtTQUNWLENBQUM7O3dCQUFBO0lBMkJGLHVCQUFDO0FBQUQsQ0ExQkEsQUEwQkMsSUFBQTtBQTFCWSx3QkFBZ0IsbUJBMEI1QixDQUFBIiwiZmlsZSI6ImFwcC9sYXlvdXQuY29udGVudC9jb250ZW50LmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBBZnRlclZpZXdJbml0LCBWaWV3Q2hpbGR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuaW1wb3J0IHtTZWN0aW9uQ29tcG9uZW50fSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi9zZWN0aW9uLmNvbXBvbmVudFwiO1xuaW1wb3J0IHtTZWN0aW9uU2VydmljZX0gZnJvbSBcIi4uL2xheW91dC5jb250ZW50LnNlY3Rpb24vc2VjdGlvbi5zZXJ2aWNlXCI7XG5cbkBDb21wb25lbnQoe1xuICBtb2R1bGVJZDogbW9kdWxlLmlkLFxuICBzZWxlY3RvcjogJ2d1aWRlbGluZS1jb250ZW50JyxcbiAgdGVtcGxhdGVVcmw6ICdjb250ZW50LmNvbXBvbmVudC5odG1sJyxcbiAgc3R5bGVVcmxzOiBbJ2NvbnRlbnQuY29tcG9uZW50LmNzcyddLFxuICBwcm92aWRlcnM6IFtdLFxuICBkaXJlY3RpdmVzOiBbXSxcbiAgcGlwZXM6IFtdXG59KVxuZXhwb3J0IGNsYXNzIENvbnRlbnRDb21wb25lbnQge1xuXG4gIEBWaWV3Q2hpbGQoJ2xlZnRTZWN0aW9uJylcbiAgcHVibGljIGxlZnRTZWN0aW9uOiBTZWN0aW9uQ29tcG9uZW50O1xuXG4gIEBWaWV3Q2hpbGQoJ3JpZ2h0U2VjdGlvbicpXG4gIHB1YmxpYyByaWdodFNlY3Rpb246IFNlY3Rpb25Db21wb25lbnQ7XG5cbiAgY29uc3RydWN0b3IgKFxuICAgIHByaXZhdGUgc2VjdGlvblNlcnZpY2U6U2VjdGlvblNlcnZpY2VcbiAgKSB7fVxuXG4gIG5nQWZ0ZXJDb250ZW50SW5pdCgpIHtcbiAgfVxuXG4gIG5nQWZ0ZXJWaWV3SW5pdCgpIHtcbiAgICB0aGlzLnNlY3Rpb25TZXJ2aWNlLmxlZnRTZWN0aW9uID0gdGhpcy5sZWZ0U2VjdGlvbjtcbiAgICB0aGlzLnNlY3Rpb25TZXJ2aWNlLnJpZ2h0U2VjdGlvbiA9IHRoaXMucmlnaHRTZWN0aW9uO1xuXG4gICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAvLyB0aGlzLnNlY3Rpb25TZXJ2aWNlLmxlZnRTZWN0aW9uLm9wZW5OYXZpZ2F0aW9uR3VpZGVsaW5lVGFiKFwiZGRkXCIpO1xuICAgICAgLy8gdGhpcy5zZWN0aW9uU2VydmljZS5sZWZ0U2VjdGlvbi5vcGVuR3VpZGVsaW5lRXZhbHVhdGlvblJlc3VsdHNUYWIoXCIyMjJcIik7XG4gICAgLy8gIHRoaXMuc2VjdGlvblNlcnZpY2UubGVmdFNlY3Rpb24ub3BlbkNyZWF0ZUd1aWRlbGluZVRhYihcIjIyMlwiKTtcbiAgICAgIHRoaXMuc2VjdGlvblNlcnZpY2UubGVmdFNlY3Rpb24ub3Blbkd1aWRlbGluZVNlbGVjdENhdGVnb3JpZXNUYWIoXCIxXCIpO1xuICAgIH0sIDEpO1xuICB9XG59XG4iXX0=
