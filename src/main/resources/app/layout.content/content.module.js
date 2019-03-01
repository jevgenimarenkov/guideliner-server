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
var content_component_1 = require("./content.component");
var section_module_1 = require("../layout.content.section/section.module");
var ContentModule = (function () {
    function ContentModule() {
    }
    ContentModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, section_module_1.SectionModule.forRoot(), shared_module_1.SharedModule],
            declarations: [content_component_1.ContentComponent],
            exports: [content_component_1.ContentComponent],
            providers: []
        }), 
        __metadata('design:paramtypes', [])
    ], ContentModule);
    return ContentModule;
}());
exports.ContentModule = ContentModule;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC9jb250ZW50Lm1vZHVsZS50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQXlCLGVBQWUsQ0FBQyxDQUFBO0FBQ3pDLHVCQUE2QixpQkFBaUIsQ0FBQyxDQUFBO0FBQy9DLDhCQUE2Qix5QkFBeUIsQ0FBQyxDQUFBO0FBQ3ZELGtDQUErQixxQkFBcUIsQ0FBQyxDQUFBO0FBQ3JELCtCQUE0QiwwQ0FBMEMsQ0FBQyxDQUFBO0FBUXZFO0lBQUE7SUFBNkIsQ0FBQztJQU45QjtRQUFDLGVBQVEsQ0FBQztZQUNSLE9BQU8sRUFBRSxDQUFDLHFCQUFZLEVBQUUsOEJBQWEsQ0FBQyxPQUFPLEVBQUUsRUFBRSw0QkFBWSxDQUFDO1lBQzlELFlBQVksRUFBRSxDQUFDLG9DQUFnQixDQUFDO1lBQ2hDLE9BQU8sRUFBRSxDQUFDLG9DQUFnQixDQUFDO1lBQzNCLFNBQVMsRUFBRSxFQUFFO1NBQ2QsQ0FBQzs7cUJBQUE7SUFDMkIsb0JBQUM7QUFBRCxDQUE3QixBQUE4QixJQUFBO0FBQWpCLHFCQUFhLGdCQUFJLENBQUEiLCJmaWxlIjoiYXBwL2xheW91dC5jb250ZW50L2NvbnRlbnQubW9kdWxlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgTmdNb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHsgQ29tbW9uTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcclxuaW1wb3J0IHsgU2hhcmVkTW9kdWxlIH0gZnJvbSAnLi4vc2hhcmVkL3NoYXJlZC5tb2R1bGUnO1xyXG5pbXBvcnQge0NvbnRlbnRDb21wb25lbnR9IGZyb20gXCIuL2NvbnRlbnQuY29tcG9uZW50XCI7XHJcbmltcG9ydCB7U2VjdGlvbk1vZHVsZX0gZnJvbSBcIi4uL2xheW91dC5jb250ZW50LnNlY3Rpb24vc2VjdGlvbi5tb2R1bGVcIjtcclxuXHJcbkBOZ01vZHVsZSh7XHJcbiAgaW1wb3J0czogW0NvbW1vbk1vZHVsZSwgU2VjdGlvbk1vZHVsZS5mb3JSb290KCksIFNoYXJlZE1vZHVsZV0sXHJcbiAgZGVjbGFyYXRpb25zOiBbQ29udGVudENvbXBvbmVudF0sXHJcbiAgZXhwb3J0czogW0NvbnRlbnRDb21wb25lbnRdLFxyXG4gIHByb3ZpZGVyczogW11cclxufSlcclxuZXhwb3J0IGNsYXNzIENvbnRlbnRNb2R1bGUgeyB9XHJcbiJdfQ==
