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
var section_component_1 = require("./section.component");
var section_service_1 = require("./section.service");
var forms_1 = require("@angular/forms");
var tabs_1 = require('ng2-bootstrap/components/tabs');
var test_tab_component_1 = require("../layout.content.section.tabs/test-tab.component");
var navigation_guideline_tab_component_1 = require("../layout.content.section.tabs/navigation-guideline-tab.component");
var view_module_1 = require("../guideline.view/view.module");
var static_guideline_evaluation_result_tab_component_1 = require("../layout.content.section.tabs/static-guideline-evaluation-result-tab.component");
var static_evaluation_results_module_1 = require("../guideline.static-evaluation-results/static-evaluation-results.module");
var guideline_evaluate_tab_component_1 = require("../layout.content.section.tabs/guideline-evaluate-tab.component");
var guideline_create_tab_component_1 = require("../layout.content.section.tabs/guideline-create-tab.component");
var guideline_select_categories_tab_component_1 = require("../layout.content.section.tabs/guideline-select-categories-tab.component");
var guideline_module_1 = require("../guideline/guideline.module");
var SectionModule = (function () {
    function SectionModule() {
    }
    SectionModule.forRoot = function () {
        return {
            ngModule: SectionModule,
            providers: [section_service_1.SectionService]
        };
    };
    SectionModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, tabs_1.TabsModule, forms_1.ReactiveFormsModule, view_module_1.GuidelineViewModule, static_evaluation_results_module_1.GuidelineStaticEvaluationResultModule, guideline_module_1.GuidelineModule],
            declarations: [section_component_1.SectionComponent, test_tab_component_1.TestTabComponent, navigation_guideline_tab_component_1.NavigationGuidelineTab, static_guideline_evaluation_result_tab_component_1.GuidelineEvaluationResultsTab, guideline_evaluate_tab_component_1.GuidelineEvaluateTab, guideline_create_tab_component_1.CreateGuidelineTab, guideline_select_categories_tab_component_1.GuidelineSelectCategoriesTab],
            entryComponents: [test_tab_component_1.TestTabComponent, navigation_guideline_tab_component_1.NavigationGuidelineTab, static_guideline_evaluation_result_tab_component_1.GuidelineEvaluationResultsTab, guideline_evaluate_tab_component_1.GuidelineEvaluateTab, guideline_create_tab_component_1.CreateGuidelineTab, guideline_select_categories_tab_component_1.GuidelineSelectCategoriesTab],
            exports: [section_component_1.SectionComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], SectionModule);
    return SectionModule;
}());
exports.SectionModule = SectionModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uL3NlY3Rpb24ubW9kdWxlLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBNEMsZUFBZSxDQUFDLENBQUE7QUFDNUQsdUJBQTZCLGlCQUFpQixDQUFDLENBQUE7QUFDL0Msa0NBQStCLHFCQUFxQixDQUFDLENBQUE7QUFDckQsZ0NBQTZCLG1CQUFtQixDQUFDLENBQUE7QUFDakQsc0JBQWtDLGdCQUFnQixDQUFDLENBQUE7QUFDbkQscUJBQTJCLCtCQUErQixDQUFDLENBQUE7QUFDM0QsbUNBQStCLG1EQUFtRCxDQUFDLENBQUE7QUFDbkYsbURBQXFDLG1FQUFtRSxDQUFDLENBQUE7QUFDekcsNEJBQWtDLCtCQUErQixDQUFDLENBQUE7QUFDbEUsaUVBQTRDLGlGQUFpRixDQUFDLENBQUE7QUFDOUgsaURBQW9ELHlFQUF5RSxDQUFDLENBQUE7QUFDOUgsaURBQW1DLGlFQUFpRSxDQUFDLENBQUE7QUFDckcsK0NBQWlDLCtEQUErRCxDQUFDLENBQUE7QUFDakcsMERBQTJDLDBFQUEwRSxDQUFDLENBQUE7QUFDdEgsaUNBQThCLCtCQUErQixDQUFDLENBQUE7QUFTOUQ7SUFBQTtJQU9BLENBQUM7SUFOUSxxQkFBTyxHQUFkO1FBQ0UsTUFBTSxDQUFDO1lBQ0wsUUFBUSxFQUFFLGFBQWE7WUFDdkIsU0FBUyxFQUFFLENBQUMsZ0NBQWMsQ0FBQztTQUM1QixDQUFDO0lBQ0osQ0FBQztJQVpIO1FBQUMsZUFBUSxDQUFDO1lBQ1IsT0FBTyxFQUFFLENBQUMscUJBQVksRUFBRSxpQkFBVSxFQUFFLDJCQUFtQixFQUFFLGlDQUFtQixFQUFFLHdFQUFxQyxFQUFFLGtDQUFlLENBQUM7WUFDckksWUFBWSxFQUFFLENBQUMsb0NBQWdCLEVBQUUscUNBQWdCLEVBQUUsMkRBQXNCLEVBQUUsZ0ZBQTZCLEVBQUUsdURBQW9CLEVBQUUsbURBQWtCLEVBQUUsd0VBQTRCLENBQUM7WUFDakwsZUFBZSxFQUFFLENBQUMscUNBQWdCLEVBQUUsMkRBQXNCLEVBQUUsZ0ZBQTZCLEVBQUUsdURBQW9CLEVBQUUsbURBQWtCLEVBQUUsd0VBQTRCLENBQUM7WUFDbEssT0FBTyxFQUFFLENBQUMsb0NBQWdCLENBQUM7U0FDNUIsQ0FBQzs7cUJBQUE7SUFRRixvQkFBQztBQUFELENBUEEsQUFPQyxJQUFBO0FBUFkscUJBQWEsZ0JBT3pCLENBQUEiLCJmaWxlIjoiYXBwL2xheW91dC5jb250ZW50LnNlY3Rpb24vc2VjdGlvbi5tb2R1bGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge05nTW9kdWxlLCBNb2R1bGVXaXRoUHJvdmlkZXJzfSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHsgQ29tbW9uTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcclxuaW1wb3J0IHtTZWN0aW9uQ29tcG9uZW50fSBmcm9tIFwiLi9zZWN0aW9uLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge1NlY3Rpb25TZXJ2aWNlfSBmcm9tIFwiLi9zZWN0aW9uLnNlcnZpY2VcIjtcclxuaW1wb3J0IHtSZWFjdGl2ZUZvcm1zTW9kdWxlfSBmcm9tIFwiQGFuZ3VsYXIvZm9ybXNcIjtcclxuaW1wb3J0IHsgVGFic01vZHVsZSB9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy90YWJzJztcclxuaW1wb3J0IHtUZXN0VGFiQ29tcG9uZW50fSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi50YWJzL3Rlc3QtdGFiLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge05hdmlnYXRpb25HdWlkZWxpbmVUYWJ9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvbmF2aWdhdGlvbi1ndWlkZWxpbmUtdGFiLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge0d1aWRlbGluZVZpZXdNb2R1bGV9IGZyb20gXCIuLi9ndWlkZWxpbmUudmlldy92aWV3Lm1vZHVsZVwiO1xyXG5pbXBvcnQge0d1aWRlbGluZUV2YWx1YXRpb25SZXN1bHRzVGFifSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi50YWJzL3N0YXRpYy1ndWlkZWxpbmUtZXZhbHVhdGlvbi1yZXN1bHQtdGFiLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge0d1aWRlbGluZVN0YXRpY0V2YWx1YXRpb25SZXN1bHRNb2R1bGV9IGZyb20gXCIuLi9ndWlkZWxpbmUuc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy9zdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzLm1vZHVsZVwiO1xyXG5pbXBvcnQge0d1aWRlbGluZUV2YWx1YXRlVGFifSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi50YWJzL2d1aWRlbGluZS1ldmFsdWF0ZS10YWIuY29tcG9uZW50XCI7XHJcbmltcG9ydCB7Q3JlYXRlR3VpZGVsaW5lVGFifSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi50YWJzL2d1aWRlbGluZS1jcmVhdGUtdGFiLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge0d1aWRlbGluZVNlbGVjdENhdGVnb3JpZXNUYWJ9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvZ3VpZGVsaW5lLXNlbGVjdC1jYXRlZ29yaWVzLXRhYi5jb21wb25lbnRcIjtcclxuaW1wb3J0IHtHdWlkZWxpbmVNb2R1bGV9IGZyb20gXCIuLi9ndWlkZWxpbmUvZ3VpZGVsaW5lLm1vZHVsZVwiO1xyXG5pbXBvcnQge0NhdGVnb3Jpc2VkR3VpZGVsaW5lc0NvbXBvbmVudH0gZnJvbSBcIi4uL2d1aWRlbGluZS9jYXRlZ29yaXNlZC1ndWlkZWxpbmUvY2F0ZWdvcmlzZWQtZ3VpZGVsaW5lLmNvbXBvbmVudFwiO1xyXG5cclxuQE5nTW9kdWxlKHtcclxuICBpbXBvcnRzOiBbQ29tbW9uTW9kdWxlLCBUYWJzTW9kdWxlLCBSZWFjdGl2ZUZvcm1zTW9kdWxlLCBHdWlkZWxpbmVWaWV3TW9kdWxlLCBHdWlkZWxpbmVTdGF0aWNFdmFsdWF0aW9uUmVzdWx0TW9kdWxlLCBHdWlkZWxpbmVNb2R1bGVdLFxyXG4gIGRlY2xhcmF0aW9uczogW1NlY3Rpb25Db21wb25lbnQsIFRlc3RUYWJDb21wb25lbnQsIE5hdmlnYXRpb25HdWlkZWxpbmVUYWIsIEd1aWRlbGluZUV2YWx1YXRpb25SZXN1bHRzVGFiLCBHdWlkZWxpbmVFdmFsdWF0ZVRhYiwgQ3JlYXRlR3VpZGVsaW5lVGFiLCBHdWlkZWxpbmVTZWxlY3RDYXRlZ29yaWVzVGFiXSxcclxuICBlbnRyeUNvbXBvbmVudHM6IFtUZXN0VGFiQ29tcG9uZW50LCBOYXZpZ2F0aW9uR3VpZGVsaW5lVGFiLCBHdWlkZWxpbmVFdmFsdWF0aW9uUmVzdWx0c1RhYiwgR3VpZGVsaW5lRXZhbHVhdGVUYWIsIENyZWF0ZUd1aWRlbGluZVRhYiwgR3VpZGVsaW5lU2VsZWN0Q2F0ZWdvcmllc1RhYl0sXHJcbiAgZXhwb3J0czogW1NlY3Rpb25Db21wb25lbnRdXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBTZWN0aW9uTW9kdWxlIHtcclxuICBzdGF0aWMgZm9yUm9vdCgpOiBNb2R1bGVXaXRoUHJvdmlkZXJzIHtcclxuICAgIHJldHVybiB7XHJcbiAgICAgIG5nTW9kdWxlOiBTZWN0aW9uTW9kdWxlLFxyXG4gICAgICBwcm92aWRlcnM6IFtTZWN0aW9uU2VydmljZV1cclxuICAgIH07XHJcbiAgfVxyXG59XHJcbiJdfQ==
