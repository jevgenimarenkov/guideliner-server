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
var static_evaluation_results_component_1 = require("./static-evaluation-results.component");
var progressbar_1 = require("ng2-bootstrap/components/progressbar");
var GuidelineStaticEvaluationResultModule = (function () {
    function GuidelineStaticEvaluationResultModule() {
    }
    GuidelineStaticEvaluationResultModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, shared_module_1.SharedModule, accordion_1.AccordionModule, modal_1.ModalModule, progressbar_1.ProgressbarModule],
            declarations: [static_evaluation_results_component_1.GuidelineStaticEvaluationResultComponent],
            exports: [static_evaluation_results_component_1.GuidelineStaticEvaluationResultComponent],
            providers: []
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineStaticEvaluationResultModule);
    return GuidelineStaticEvaluationResultModule;
}());
exports.GuidelineStaticEvaluationResultModule = GuidelineStaticEvaluationResultModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUuc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy9zdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzLm1vZHVsZS50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQXlCLGVBQWUsQ0FBQyxDQUFBO0FBQ3pDLHVCQUE2QixpQkFBaUIsQ0FBQyxDQUFBO0FBQy9DLDhCQUE2Qix5QkFBeUIsQ0FBQyxDQUFBO0FBQ3ZELDBCQUE4QixvQ0FBb0MsQ0FBQyxDQUFBO0FBQ25FLHNCQUEwQixnQ0FBZ0MsQ0FBQyxDQUFBO0FBQzNELG9EQUF1RCx1Q0FBdUMsQ0FBQyxDQUFBO0FBQy9GLDRCQUFnQyxzQ0FBc0MsQ0FBQyxDQUFBO0FBUXZFO0lBQUE7SUFBcUQsQ0FBQztJQU50RDtRQUFDLGVBQVEsQ0FBQztZQUNSLE9BQU8sRUFBRSxDQUFDLHFCQUFZLEVBQUUsNEJBQVksRUFBRSwyQkFBZSxFQUFFLG1CQUFXLEVBQUUsK0JBQWlCLENBQUM7WUFDdEYsWUFBWSxFQUFFLENBQUMsOEVBQXdDLENBQUM7WUFDeEQsT0FBTyxFQUFFLENBQUMsOEVBQXdDLENBQUM7WUFDbkQsU0FBUyxFQUFFLEVBQUU7U0FDZCxDQUFDOzs2Q0FBQTtJQUNtRCw0Q0FBQztBQUFELENBQXJELEFBQXNELElBQUE7QUFBekMsNkNBQXFDLHdDQUFJLENBQUEiLCJmaWxlIjoiYXBwL2d1aWRlbGluZS5zdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzL3N0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMubW9kdWxlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgTmdNb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHsgQ29tbW9uTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcclxuaW1wb3J0IHsgU2hhcmVkTW9kdWxlIH0gZnJvbSAnLi4vc2hhcmVkL3NoYXJlZC5tb2R1bGUnO1xyXG5pbXBvcnQge0FjY29yZGlvbk1vZHVsZX0gZnJvbSAnbmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL2FjY29yZGlvbic7XHJcbmltcG9ydCB7TW9kYWxNb2R1bGV9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy9tb2RhbCc7XHJcbmltcG9ydCB7R3VpZGVsaW5lU3RhdGljRXZhbHVhdGlvblJlc3VsdENvbXBvbmVudH0gZnJvbSBcIi4vc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy5jb21wb25lbnRcIjtcclxuaW1wb3J0IHtQcm9ncmVzc2Jhck1vZHVsZX0gZnJvbSBcIm5nMi1ib290c3RyYXAvY29tcG9uZW50cy9wcm9ncmVzc2JhclwiO1xyXG5cclxuQE5nTW9kdWxlKHtcclxuICBpbXBvcnRzOiBbQ29tbW9uTW9kdWxlLCBTaGFyZWRNb2R1bGUsIEFjY29yZGlvbk1vZHVsZSwgTW9kYWxNb2R1bGUsIFByb2dyZXNzYmFyTW9kdWxlXSxcclxuICBkZWNsYXJhdGlvbnM6IFtHdWlkZWxpbmVTdGF0aWNFdmFsdWF0aW9uUmVzdWx0Q29tcG9uZW50XSxcclxuICBleHBvcnRzOiBbR3VpZGVsaW5lU3RhdGljRXZhbHVhdGlvblJlc3VsdENvbXBvbmVudF0sXHJcbiAgcHJvdmlkZXJzOiBbXVxyXG59KVxyXG5leHBvcnQgY2xhc3MgR3VpZGVsaW5lU3RhdGljRXZhbHVhdGlvblJlc3VsdE1vZHVsZSB7IH1cclxuIl19
