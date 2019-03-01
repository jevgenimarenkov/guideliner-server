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
var platform_browser_1 = require('@angular/platform-browser');
var common_1 = require('@angular/common');
var http_1 = require('@angular/http');
var app_component_1 = require('./app.component');
var shared_module_1 = require('./shared/shared.module');
var footer_module_1 = require("./layout.footer/footer.module");
var menu_module_1 = require("./layout.menu/menu.module");
var content_module_1 = require("./layout.content/content.module");
var section_service_1 = require("./layout.content.section/section.service");
var view_module_1 = require("./guideline.view/view.module");
var static_evaluation_results_module_1 = require("./guideline.static-evaluation-results/static-evaluation-results.module");
var select_categories_module_1 = require("./guideline.select-categories/select-categories.module");
var usability_service_1 = require("./guideline/shared/usability.service");
var guideline_module_1 = require("./guideline/guideline.module");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [platform_browser_1.BrowserModule, http_1.HttpModule, footer_module_1.FooterModule, menu_module_1.MenuModule, content_module_1.ContentModule, view_module_1.GuidelineViewModule,
                static_evaluation_results_module_1.GuidelineStaticEvaluationResultModule, guideline_module_1.GuidelineModule, select_categories_module_1.SelectCategoriesModule, shared_module_1.SharedModule.forRoot()],
            declarations: [app_component_1.AppComponent],
            providers: [{
                    provide: common_1.APP_BASE_HREF,
                    useValue: '/'
                },
                section_service_1.SectionService,
                usability_service_1.UsabilityService],
            bootstrap: [app_component_1.AppComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9hcHAubW9kdWxlLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBeUIsZUFBZSxDQUFDLENBQUE7QUFDekMsaUNBQThCLDJCQUEyQixDQUFDLENBQUE7QUFDMUQsdUJBQThCLGlCQUFpQixDQUFDLENBQUE7QUFDaEQscUJBQTJCLGVBQWUsQ0FBQyxDQUFBO0FBQzNDLDhCQUE2QixpQkFBaUIsQ0FBQyxDQUFBO0FBRS9DLDhCQUE2Qix3QkFBd0IsQ0FBQyxDQUFBO0FBQ3RELDhCQUEyQiwrQkFBK0IsQ0FBQyxDQUFBO0FBQzNELDRCQUF5QiwyQkFBMkIsQ0FBQyxDQUFBO0FBQ3JELCtCQUE0QixpQ0FBaUMsQ0FBQyxDQUFBO0FBQzlELGdDQUE2QiwwQ0FBMEMsQ0FBQyxDQUFBO0FBQ3hFLDRCQUFrQyw4QkFBOEIsQ0FBQyxDQUFBO0FBQ2pFLGlEQUFvRCx3RUFBd0UsQ0FBQyxDQUFBO0FBQzdILHlDQUFxQyx3REFBd0QsQ0FBQyxDQUFBO0FBQzlGLGtDQUErQixzQ0FBc0MsQ0FBQyxDQUFBO0FBQ3RFLGlDQUE4Qiw4QkFBOEIsQ0FBQyxDQUFBO0FBZTdEO0lBQUE7SUFBeUIsQ0FBQztJQWIxQjtRQUFDLGVBQVEsQ0FBQztZQUNSLE9BQU8sRUFBRSxDQUFDLGdDQUFhLEVBQUUsaUJBQVUsRUFBRSw0QkFBWSxFQUFFLHdCQUFVLEVBQUUsOEJBQWEsRUFBRSxpQ0FBbUI7Z0JBQy9GLHdFQUFxQyxFQUFFLGtDQUFlLEVBQUUsaURBQXNCLEVBQUUsNEJBQVksQ0FBQyxPQUFPLEVBQUUsQ0FBQztZQUN6RyxZQUFZLEVBQUUsQ0FBQyw0QkFBWSxDQUFDO1lBQzVCLFNBQVMsRUFBRSxDQUFDO29CQUNWLE9BQU8sRUFBRSxzQkFBYTtvQkFDdEIsUUFBUSxFQUFFLGlCQUFpQjtpQkFDNUI7Z0JBQ0MsZ0NBQWM7Z0JBQ2Qsb0NBQWdCLENBQUM7WUFDbkIsU0FBUyxFQUFFLENBQUMsNEJBQVksQ0FBQztTQUUxQixDQUFDOztpQkFBQTtJQUN1QixnQkFBQztBQUFELENBQXpCLEFBQTBCLElBQUE7QUFBYixpQkFBUyxZQUFJLENBQUEiLCJmaWxlIjoiYXBwL2FwcC5tb2R1bGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBOZ01vZHVsZSB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQgeyBCcm93c2VyTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvcGxhdGZvcm0tYnJvd3Nlcic7XHJcbmltcG9ydCB7IEFQUF9CQVNFX0hSRUYgfSBmcm9tICdAYW5ndWxhci9jb21tb24nO1xyXG5pbXBvcnQgeyBIdHRwTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvaHR0cCc7XHJcbmltcG9ydCB7IEFwcENvbXBvbmVudCB9IGZyb20gJy4vYXBwLmNvbXBvbmVudCc7XHJcblxyXG5pbXBvcnQgeyBTaGFyZWRNb2R1bGUgfSBmcm9tICcuL3NoYXJlZC9zaGFyZWQubW9kdWxlJztcclxuaW1wb3J0IHtGb290ZXJNb2R1bGV9IGZyb20gXCIuL2xheW91dC5mb290ZXIvZm9vdGVyLm1vZHVsZVwiO1xyXG5pbXBvcnQge01lbnVNb2R1bGV9IGZyb20gXCIuL2xheW91dC5tZW51L21lbnUubW9kdWxlXCI7XHJcbmltcG9ydCB7Q29udGVudE1vZHVsZX0gZnJvbSBcIi4vbGF5b3V0LmNvbnRlbnQvY29udGVudC5tb2R1bGVcIjtcclxuaW1wb3J0IHtTZWN0aW9uU2VydmljZX0gZnJvbSBcIi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi9zZWN0aW9uLnNlcnZpY2VcIjtcclxuaW1wb3J0IHtHdWlkZWxpbmVWaWV3TW9kdWxlfSBmcm9tIFwiLi9ndWlkZWxpbmUudmlldy92aWV3Lm1vZHVsZVwiO1xyXG5pbXBvcnQge0d1aWRlbGluZVN0YXRpY0V2YWx1YXRpb25SZXN1bHRNb2R1bGV9IGZyb20gXCIuL2d1aWRlbGluZS5zdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzL3N0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMubW9kdWxlXCI7XHJcbmltcG9ydCB7U2VsZWN0Q2F0ZWdvcmllc01vZHVsZX0gZnJvbSBcIi4vZ3VpZGVsaW5lLnNlbGVjdC1jYXRlZ29yaWVzL3NlbGVjdC1jYXRlZ29yaWVzLm1vZHVsZVwiO1xyXG5pbXBvcnQge1VzYWJpbGl0eVNlcnZpY2V9IGZyb20gXCIuL2d1aWRlbGluZS9zaGFyZWQvdXNhYmlsaXR5LnNlcnZpY2VcIjtcclxuaW1wb3J0IHtHdWlkZWxpbmVNb2R1bGV9IGZyb20gXCIuL2d1aWRlbGluZS9ndWlkZWxpbmUubW9kdWxlXCI7XHJcblxyXG5ATmdNb2R1bGUoe1xyXG4gIGltcG9ydHM6IFtCcm93c2VyTW9kdWxlLCBIdHRwTW9kdWxlLCBGb290ZXJNb2R1bGUsIE1lbnVNb2R1bGUsIENvbnRlbnRNb2R1bGUsIEd1aWRlbGluZVZpZXdNb2R1bGUsXHJcbiAgICBHdWlkZWxpbmVTdGF0aWNFdmFsdWF0aW9uUmVzdWx0TW9kdWxlLCBHdWlkZWxpbmVNb2R1bGUsIFNlbGVjdENhdGVnb3JpZXNNb2R1bGUsIFNoYXJlZE1vZHVsZS5mb3JSb290KCldLFxyXG4gIGRlY2xhcmF0aW9uczogW0FwcENvbXBvbmVudF0sXHJcbiAgcHJvdmlkZXJzOiBbe1xyXG4gICAgcHJvdmlkZTogQVBQX0JBU0VfSFJFRixcclxuICAgIHVzZVZhbHVlOiAnPCU9IEFQUF9CQVNFICU+J1xyXG4gIH0sXHJcbiAgICBTZWN0aW9uU2VydmljZSxcclxuICAgIFVzYWJpbGl0eVNlcnZpY2VdLFxyXG4gIGJvb3RzdHJhcDogW0FwcENvbXBvbmVudF1cclxuXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBBcHBNb2R1bGUgeyB9XHJcbiJdfQ==
