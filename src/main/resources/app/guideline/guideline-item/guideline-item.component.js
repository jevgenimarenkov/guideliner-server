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
var guideline_1 = require("../../guideline.view/guideline");
var GuidelineItemComponent = (function () {
    function GuidelineItemComponent() {
    }
    GuidelineItemComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', guideline_1.Guideline)
    ], GuidelineItemComponent.prototype, "guideline", void 0);
    GuidelineItemComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'guideline-item',
            templateUrl: 'guideline-item.component.html',
            providers: [],
            pipes: []
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineItemComponent);
    return GuidelineItemComponent;
}());
exports.GuidelineItemComponent = GuidelineItemComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvZ3VpZGVsaW5lLWl0ZW0vZ3VpZGVsaW5lLWl0ZW0uY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBa0QsZUFBZSxDQUFDLENBQUE7QUFFbEUsMEJBQTBDLGdDQUFnQyxDQUFDLENBQUE7QUFlM0U7SUFLRTtJQUNBLENBQUM7SUFFRCx5Q0FBUSxHQUFSO0lBQ0EsQ0FBQztJQVBEO1FBQUMsWUFBSyxFQUFFOzs2REFBQTtJQVRWO1FBQUMsZ0JBQVMsQ0FBQztZQUNULFFBQVEsRUFBRSxNQUFNLENBQUMsRUFBRTtZQUNuQixRQUFRLEVBQUUsZ0JBQWdCO1lBQzFCLFdBQVcsRUFBRSwrQkFBK0I7WUFDNUMsU0FBUyxFQUFFLEVBQUU7WUFDYixLQUFLLEVBQUUsRUFBRTtTQUNWLENBQUM7OzhCQUFBO0lBY0YsNkJBQUM7QUFBRCxDQWJBLEFBYUMsSUFBQTtBQWJZLDhCQUFzQix5QkFhbEMsQ0FBQSIsImZpbGUiOiJhcHAvZ3VpZGVsaW5lL2d1aWRlbGluZS1pdGVtL2d1aWRlbGluZS1pdGVtLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBPbkluaXQsIFZpZXdDaGlsZCwgSW5wdXR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge01vZGFsRGlyZWN0aXZlfSBmcm9tIFwibmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL21vZGFsL21vZGFsLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge0V2YWx1YXRpb25SZXN1bHQsIEd1aWRlbGluZX0gZnJvbSBcIi4uLy4uL2d1aWRlbGluZS52aWV3L2d1aWRlbGluZVwiO1xyXG5pbXBvcnQge09ic2VydmFibGV9IGZyb20gXCJyeGpzXCI7XHJcbmltcG9ydCB7SHR0cH0gZnJvbSBcIkBhbmd1bGFyL2h0dHBcIjtcclxuaW1wb3J0IHsgVmlld0NvbnRhaW5lclJlZiB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQgeyBDb21wb25lbnRzSGVscGVyIH0gZnJvbSAnbmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL3V0aWxzL2NvbXBvbmVudHMtaGVscGVyLnNlcnZpY2UnO1xyXG5pbXBvcnQge1VzYWJpbGl0eVNlcnZpY2V9IGZyb20gXCIuLi9zaGFyZWQvdXNhYmlsaXR5LnNlcnZpY2VcIjtcclxuaW1wb3J0IHtDYXRlZ29yeUV2YWx1YXRpb259IGZyb20gXCIuLi8uLi9zaGFyZWQvZXZhbHVhdGlvbi5kdG9cIjtcclxuXHJcbkBDb21wb25lbnQoe1xyXG4gIG1vZHVsZUlkOiBtb2R1bGUuaWQsXHJcbiAgc2VsZWN0b3I6ICdndWlkZWxpbmUtaXRlbScsXHJcbiAgdGVtcGxhdGVVcmw6ICdndWlkZWxpbmUtaXRlbS5jb21wb25lbnQuaHRtbCcsXHJcbiAgcHJvdmlkZXJzOiBbXSxcclxuICBwaXBlczogW11cclxufSlcclxuZXhwb3J0IGNsYXNzIEd1aWRlbGluZUl0ZW1Db21wb25lbnQgaW1wbGVtZW50cyBPbkluaXQge1xyXG5cclxuICBASW5wdXQoKVxyXG4gIGd1aWRlbGluZTogR3VpZGVsaW5lO1xyXG5cclxuICBjb25zdHJ1Y3RvcigpIHtcclxuICB9XHJcblxyXG4gIG5nT25Jbml0KCk6IHZvaWQge1xyXG4gIH1cclxuXHJcblxyXG5cclxufVxyXG4iXX0=
