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
var create_component_1 = require("./create/create.component");
var evaluate_component_1 = require("./evaluate/evaluate.component");
var accordion_1 = require('ng2-bootstrap/components/accordion');
var modal_1 = require('ng2-bootstrap/components/modal');
var progressbar_1 = require("ng2-bootstrap/components/progressbar");
var loading_indicator_1 = require("./evaluate/loading-indicator");
var categorised_guideline_component_1 = require("./categorised-guideline/categorised-guideline.component");
var buttons_1 = require('ng2-bootstrap/components/buttons');
var guideline_item_component_1 = require("./guideline-item/guideline-item.component");
var evaluation_result_item_component_1 = require("./evaluation-result-item/evaluation-result-item.component");
var GuidelineModule = (function () {
    function GuidelineModule() {
    }
    GuidelineModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, shared_module_1.SharedModule, common_1.CommonModule, shared_module_1.SharedModule, accordion_1.AccordionModule, modal_1.ModalModule, progressbar_1.ProgressbarModule, buttons_1.ButtonsModule],
            declarations: [create_component_1.CreateGuidelineComponent, evaluate_component_1.GuidelineEvaluateComponent, loading_indicator_1.LoadingIndicator, categorised_guideline_component_1.CategorisedGuidelinesComponent, guideline_item_component_1.GuidelineItemComponent, evaluation_result_item_component_1.EvaluationResultItemComponent],
            exports: [create_component_1.CreateGuidelineComponent, evaluate_component_1.GuidelineEvaluateComponent, loading_indicator_1.LoadingIndicator, categorised_guideline_component_1.CategorisedGuidelinesComponent],
            providers: []
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineModule);
    return GuidelineModule;
}());
exports.GuidelineModule = GuidelineModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvZ3VpZGVsaW5lLm1vZHVsZS50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQXlCLGVBQWUsQ0FBQyxDQUFBO0FBQ3pDLHVCQUE2QixpQkFBaUIsQ0FBQyxDQUFBO0FBQy9DLDhCQUE2Qix5QkFBeUIsQ0FBQyxDQUFBO0FBQ3ZELGlDQUF1QywyQkFBMkIsQ0FBQyxDQUFBO0FBQ25FLG1DQUF5QywrQkFBK0IsQ0FBQyxDQUFBO0FBQ3pFLDBCQUE4QixvQ0FBb0MsQ0FBQyxDQUFBO0FBQ25FLHNCQUEwQixnQ0FBZ0MsQ0FBQyxDQUFBO0FBQzNELDRCQUFnQyxzQ0FBc0MsQ0FBQyxDQUFBO0FBQ3ZFLGtDQUErQiw4QkFBOEIsQ0FBQyxDQUFBO0FBQzlELGdEQUE2Qyx5REFBeUQsQ0FBQyxDQUFBO0FBQ3ZHLHdCQUE4QixrQ0FBa0MsQ0FBQyxDQUFBO0FBQ2pFLHlDQUFxQywyQ0FBMkMsQ0FBQyxDQUFBO0FBQ2pGLGlEQUE0QywyREFBMkQsQ0FBQyxDQUFBO0FBUXhHO0lBQUE7SUFBOEIsQ0FBQztJQU4vQjtRQUFDLGVBQVEsQ0FBQztZQUNSLE9BQU8sRUFBRSxDQUFDLHFCQUFZLEVBQUUsNEJBQVksRUFBRSxxQkFBWSxFQUFFLDRCQUFZLEVBQUUsMkJBQWUsRUFBRSxtQkFBVyxFQUFFLCtCQUFpQixFQUFFLHVCQUFhLENBQUM7WUFDakksWUFBWSxFQUFFLENBQUMsMkNBQXdCLEVBQUUsK0NBQTBCLEVBQUUsb0NBQWdCLEVBQUUsZ0VBQThCLEVBQUUsaURBQXNCLEVBQUUsZ0VBQTZCLENBQUM7WUFDN0ssT0FBTyxFQUFFLENBQUMsMkNBQXdCLEVBQUUsK0NBQTBCLEVBQUUsb0NBQWdCLEVBQUUsZ0VBQThCLENBQUM7WUFDakgsU0FBUyxFQUFFLEVBQUU7U0FDZCxDQUFDOzt1QkFBQTtJQUM0QixzQkFBQztBQUFELENBQTlCLEFBQStCLElBQUE7QUFBbEIsdUJBQWUsa0JBQUcsQ0FBQSIsImZpbGUiOiJhcHAvZ3VpZGVsaW5lL2d1aWRlbGluZS5tb2R1bGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBOZ01vZHVsZSB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQgeyBDb21tb25Nb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb21tb24nO1xyXG5pbXBvcnQgeyBTaGFyZWRNb2R1bGUgfSBmcm9tICcuLi9zaGFyZWQvc2hhcmVkLm1vZHVsZSc7XHJcbmltcG9ydCB7Q3JlYXRlR3VpZGVsaW5lQ29tcG9uZW50fSBmcm9tIFwiLi9jcmVhdGUvY3JlYXRlLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge0d1aWRlbGluZUV2YWx1YXRlQ29tcG9uZW50fSBmcm9tIFwiLi9ldmFsdWF0ZS9ldmFsdWF0ZS5jb21wb25lbnRcIjtcclxuaW1wb3J0IHtBY2NvcmRpb25Nb2R1bGV9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy9hY2NvcmRpb24nO1xyXG5pbXBvcnQge01vZGFsTW9kdWxlfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvbW9kYWwnO1xyXG5pbXBvcnQge1Byb2dyZXNzYmFyTW9kdWxlfSBmcm9tIFwibmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL3Byb2dyZXNzYmFyXCI7XHJcbmltcG9ydCB7TG9hZGluZ0luZGljYXRvcn0gZnJvbSBcIi4vZXZhbHVhdGUvbG9hZGluZy1pbmRpY2F0b3JcIjtcclxuaW1wb3J0IHtDYXRlZ29yaXNlZEd1aWRlbGluZXNDb21wb25lbnR9IGZyb20gXCIuL2NhdGVnb3Jpc2VkLWd1aWRlbGluZS9jYXRlZ29yaXNlZC1ndWlkZWxpbmUuY29tcG9uZW50XCI7XHJcbmltcG9ydCB7IEJ1dHRvbnNNb2R1bGUgfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvYnV0dG9ucyc7XHJcbmltcG9ydCB7R3VpZGVsaW5lSXRlbUNvbXBvbmVudH0gZnJvbSBcIi4vZ3VpZGVsaW5lLWl0ZW0vZ3VpZGVsaW5lLWl0ZW0uY29tcG9uZW50XCI7XHJcbmltcG9ydCB7RXZhbHVhdGlvblJlc3VsdEl0ZW1Db21wb25lbnR9IGZyb20gXCIuL2V2YWx1YXRpb24tcmVzdWx0LWl0ZW0vZXZhbHVhdGlvbi1yZXN1bHQtaXRlbS5jb21wb25lbnRcIjtcclxuXHJcbkBOZ01vZHVsZSh7XHJcbiAgaW1wb3J0czogW0NvbW1vbk1vZHVsZSwgU2hhcmVkTW9kdWxlLCBDb21tb25Nb2R1bGUsIFNoYXJlZE1vZHVsZSwgQWNjb3JkaW9uTW9kdWxlLCBNb2RhbE1vZHVsZSwgUHJvZ3Jlc3NiYXJNb2R1bGUsIEJ1dHRvbnNNb2R1bGVdLFxyXG4gIGRlY2xhcmF0aW9uczogW0NyZWF0ZUd1aWRlbGluZUNvbXBvbmVudCwgR3VpZGVsaW5lRXZhbHVhdGVDb21wb25lbnQsIExvYWRpbmdJbmRpY2F0b3IsIENhdGVnb3Jpc2VkR3VpZGVsaW5lc0NvbXBvbmVudCwgR3VpZGVsaW5lSXRlbUNvbXBvbmVudCwgRXZhbHVhdGlvblJlc3VsdEl0ZW1Db21wb25lbnRdLFxyXG4gIGV4cG9ydHM6IFtDcmVhdGVHdWlkZWxpbmVDb21wb25lbnQsIEd1aWRlbGluZUV2YWx1YXRlQ29tcG9uZW50LCBMb2FkaW5nSW5kaWNhdG9yLCBDYXRlZ29yaXNlZEd1aWRlbGluZXNDb21wb25lbnRdLFxyXG4gIHByb3ZpZGVyczogW11cclxufSlcclxuZXhwb3J0IGNsYXNzIEd1aWRlbGluZU1vZHVsZSB7fVxyXG4iXX0=
