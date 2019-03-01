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
var accordion_1 = require('ng2-bootstrap/components/accordion');
var modal_1 = require('ng2-bootstrap/components/modal');
var select_categories_component_1 = require("./select-categories.component");
var dropdown_1 = require('ng2-bootstrap/components/dropdown');
var buttons_1 = require('ng2-bootstrap/components/buttons');
var SelectCategoriesModule = (function () {
    function SelectCategoriesModule() {
    }
    SelectCategoriesModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, shared_module_1.SharedModule, accordion_1.AccordionModule, modal_1.ModalModule, dropdown_1.DropdownModule, buttons_1.ButtonsModule],
            declarations: [select_categories_component_1.SelectCategoriesComponent],
            exports: [select_categories_component_1.SelectCategoriesComponent],
            providers: []
        }), 
        __metadata('design:paramtypes', [])
    ], SelectCategoriesModule);
    return SelectCategoriesModule;
}());
exports.SelectCategoriesModule = SelectCategoriesModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUuc2VsZWN0LWNhdGVnb3JpZXMvc2VsZWN0LWNhdGVnb3JpZXMubW9kdWxlLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBeUIsZUFBZSxDQUFDLENBQUE7QUFDekMsdUJBQTZCLGlCQUFpQixDQUFDLENBQUE7QUFDL0MsOEJBQTZCLHlCQUF5QixDQUFDLENBQUE7QUFDdkQsMEJBQThCLG9DQUFvQyxDQUFDLENBQUE7QUFDbkUsc0JBQTBCLGdDQUFnQyxDQUFDLENBQUE7QUFDM0QsNENBQXdDLCtCQUErQixDQUFDLENBQUE7QUFDeEUseUJBQStCLG1DQUFtQyxDQUFDLENBQUE7QUFDbkUsd0JBQThCLGtDQUFrQyxDQUFDLENBQUE7QUFRakU7SUFBQTtJQUFzQyxDQUFDO0lBTnZDO1FBQUMsZUFBUSxDQUFDO1lBQ1IsT0FBTyxFQUFFLENBQUMscUJBQVksRUFBRSw0QkFBWSxFQUFFLDJCQUFlLEVBQUUsbUJBQVcsRUFBRSx5QkFBYyxFQUFFLHVCQUFhLENBQUM7WUFDbEcsWUFBWSxFQUFFLENBQUMsdURBQXlCLENBQUM7WUFDekMsT0FBTyxFQUFFLENBQUMsdURBQXlCLENBQUM7WUFDcEMsU0FBUyxFQUFFLEVBQUU7U0FDZCxDQUFDOzs4QkFBQTtJQUNvQyw2QkFBQztBQUFELENBQXRDLEFBQXVDLElBQUE7QUFBMUIsOEJBQXNCLHlCQUFJLENBQUEiLCJmaWxlIjoiYXBwL2d1aWRlbGluZS5zZWxlY3QtY2F0ZWdvcmllcy9zZWxlY3QtY2F0ZWdvcmllcy5tb2R1bGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBOZ01vZHVsZSB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQgeyBDb21tb25Nb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb21tb24nO1xyXG5pbXBvcnQgeyBTaGFyZWRNb2R1bGUgfSBmcm9tICcuLi9zaGFyZWQvc2hhcmVkLm1vZHVsZSc7XHJcbmltcG9ydCB7QWNjb3JkaW9uTW9kdWxlfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvYWNjb3JkaW9uJztcclxuaW1wb3J0IHtNb2RhbE1vZHVsZX0gZnJvbSAnbmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL21vZGFsJztcclxuaW1wb3J0IHtTZWxlY3RDYXRlZ29yaWVzQ29tcG9uZW50fSBmcm9tIFwiLi9zZWxlY3QtY2F0ZWdvcmllcy5jb21wb25lbnRcIjtcclxuaW1wb3J0IHsgRHJvcGRvd25Nb2R1bGUgfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvZHJvcGRvd24nO1xyXG5pbXBvcnQgeyBCdXR0b25zTW9kdWxlIH0gZnJvbSAnbmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL2J1dHRvbnMnO1xyXG5cclxuQE5nTW9kdWxlKHtcclxuICBpbXBvcnRzOiBbQ29tbW9uTW9kdWxlLCBTaGFyZWRNb2R1bGUsIEFjY29yZGlvbk1vZHVsZSwgTW9kYWxNb2R1bGUsIERyb3Bkb3duTW9kdWxlLCBCdXR0b25zTW9kdWxlXSxcclxuICBkZWNsYXJhdGlvbnM6IFtTZWxlY3RDYXRlZ29yaWVzQ29tcG9uZW50XSxcclxuICBleHBvcnRzOiBbU2VsZWN0Q2F0ZWdvcmllc0NvbXBvbmVudF0sXHJcbiAgcHJvdmlkZXJzOiBbXVxyXG59KVxyXG5leHBvcnQgY2xhc3MgU2VsZWN0Q2F0ZWdvcmllc01vZHVsZSB7IH1cclxuIl19
