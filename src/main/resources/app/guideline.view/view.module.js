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
var common_1 = require('@angular/common');
var shared_module_1 = require('../shared/shared.module');
var view_component_1 = require("./view.component");
var accordion_1 = require('ng2-bootstrap/components/accordion');
var modal_1 = require('ng2-bootstrap/components/modal');
var GuidelineViewModule = (function () {
    function GuidelineViewModule() {
    }
    GuidelineViewModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, shared_module_1.SharedModule, accordion_1.AccordionModule, modal_1.ModalModule],
            declarations: [view_component_1.GuidelineViewComponent],
            exports: [view_component_1.GuidelineViewComponent],
            providers: []
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineViewModule);
    return GuidelineViewModule;
}());
exports.GuidelineViewModule = GuidelineViewModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUudmlldy92aWV3Lm1vZHVsZS50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQXlCLGVBQWUsQ0FBQyxDQUFBO0FBQ3pDLHVCQUE2QixpQkFBaUIsQ0FBQyxDQUFBO0FBQy9DLDhCQUE2Qix5QkFBeUIsQ0FBQyxDQUFBO0FBRXZELCtCQUFxQyxrQkFBa0IsQ0FBQyxDQUFBO0FBQ3hELDBCQUE4QixvQ0FBb0MsQ0FBQyxDQUFBO0FBQ25FLHNCQUEwQixnQ0FBZ0MsQ0FBQyxDQUFBO0FBUTNEO0lBQUE7SUFBbUMsQ0FBQztJQU5wQztRQUFDLGVBQVEsQ0FBQztZQUNSLE9BQU8sRUFBRSxDQUFDLHFCQUFZLEVBQUUsNEJBQVksRUFBRSwyQkFBZSxFQUFFLG1CQUFXLENBQUM7WUFDbkUsWUFBWSxFQUFFLENBQUMsdUNBQXNCLENBQUM7WUFDdEMsT0FBTyxFQUFFLENBQUMsdUNBQXNCLENBQUM7WUFDakMsU0FBUyxFQUFFLEVBQUU7U0FDZCxDQUFDOzsyQkFBQTtJQUNpQywwQkFBQztBQUFELENBQW5DLEFBQW9DLElBQUE7QUFBdkIsMkJBQW1CLHNCQUFJLENBQUEiLCJmaWxlIjoiYXBwL2d1aWRlbGluZS52aWV3L3ZpZXcubW9kdWxlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgTmdNb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHsgQ29tbW9uTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcclxuaW1wb3J0IHsgU2hhcmVkTW9kdWxlIH0gZnJvbSAnLi4vc2hhcmVkL3NoYXJlZC5tb2R1bGUnO1xyXG5pbXBvcnQge1NlY3Rpb25Nb2R1bGV9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uL3NlY3Rpb24ubW9kdWxlXCI7XHJcbmltcG9ydCB7R3VpZGVsaW5lVmlld0NvbXBvbmVudH0gZnJvbSBcIi4vdmlldy5jb21wb25lbnRcIjtcclxuaW1wb3J0IHtBY2NvcmRpb25Nb2R1bGV9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy9hY2NvcmRpb24nO1xyXG5pbXBvcnQge01vZGFsTW9kdWxlfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvbW9kYWwnO1xyXG5cclxuQE5nTW9kdWxlKHtcclxuICBpbXBvcnRzOiBbQ29tbW9uTW9kdWxlLCBTaGFyZWRNb2R1bGUsIEFjY29yZGlvbk1vZHVsZSwgTW9kYWxNb2R1bGVdLFxyXG4gIGRlY2xhcmF0aW9uczogW0d1aWRlbGluZVZpZXdDb21wb25lbnRdLFxyXG4gIGV4cG9ydHM6IFtHdWlkZWxpbmVWaWV3Q29tcG9uZW50XSxcclxuICBwcm92aWRlcnM6IFtdXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBHdWlkZWxpbmVWaWV3TW9kdWxlIHsgfVxyXG4iXX0=
