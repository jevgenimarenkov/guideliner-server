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
var section_service_1 = require("../layout.content.section/section.service");
var MenuComponent = (function () {
    function MenuComponent(sectionService) {
        this.sectionService = sectionService;
    }
    MenuComponent.prototype.addName = function () {
        this.sectionService.leftSection.openNavigationGuidelineTab("dd");
    };
    MenuComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'guideline-menu',
            templateUrl: 'menu.component.html',
            styleUrls: ['menu.component.css'],
            providers: [],
            directives: [],
            pipes: []
        }), 
        __metadata('design:paramtypes', [section_service_1.SectionService])
    ], MenuComponent);
    return MenuComponent;
}());
exports.MenuComponent = MenuComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQubWVudS9tZW51LmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQTBCLGVBQWUsQ0FBQyxDQUFBO0FBRTFDLGdDQUE2QiwyQ0FBMkMsQ0FBQyxDQUFBO0FBWXpFO0lBRUUsdUJBQ1UsY0FBNkI7UUFBN0IsbUJBQWMsR0FBZCxjQUFjLENBQWU7SUFDcEMsQ0FBQztJQUVKLCtCQUFPLEdBQVA7UUFDRSxJQUFJLENBQUMsY0FBYyxDQUFDLFdBQVcsQ0FBQywwQkFBMEIsQ0FBQyxJQUFJLENBQUMsQ0FBQztJQUNuRSxDQUFDO0lBakJIO1FBQUMsZ0JBQVMsQ0FBQztZQUNULFFBQVEsRUFBRSxNQUFNLENBQUMsRUFBRTtZQUNuQixRQUFRLEVBQUUsZ0JBQWdCO1lBQzFCLFdBQVcsRUFBRSxxQkFBcUI7WUFDbEMsU0FBUyxFQUFFLENBQUMsb0JBQW9CLENBQUM7WUFDakMsU0FBUyxFQUFFLEVBQUU7WUFDYixVQUFVLEVBQUUsRUFBRTtZQUNkLEtBQUssRUFBRSxFQUFFO1NBQ1YsQ0FBQzs7cUJBQUE7SUFXRixvQkFBQztBQUFELENBVkEsQUFVQyxJQUFBO0FBVlkscUJBQWEsZ0JBVXpCLENBQUEiLCJmaWxlIjoiYXBwL2xheW91dC5tZW51L21lbnUuY29tcG9uZW50LmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgQ29tcG9uZW50IH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XHJcbmltcG9ydCB7RW52Q29uZmlnfSBmcm9tIFwiLi4vc2hhcmVkL2NvbmZpZy9lbnYuY29uZmlnXCI7XHJcbmltcG9ydCB7U2VjdGlvblNlcnZpY2V9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uL3NlY3Rpb24uc2VydmljZVwiO1xyXG5cclxuXHJcbkBDb21wb25lbnQoe1xyXG4gIG1vZHVsZUlkOiBtb2R1bGUuaWQsXHJcbiAgc2VsZWN0b3I6ICdndWlkZWxpbmUtbWVudScsXHJcbiAgdGVtcGxhdGVVcmw6ICdtZW51LmNvbXBvbmVudC5odG1sJyxcclxuICBzdHlsZVVybHM6IFsnbWVudS5jb21wb25lbnQuY3NzJ10sXHJcbiAgcHJvdmlkZXJzOiBbXSxcclxuICBkaXJlY3RpdmVzOiBbXSxcclxuICBwaXBlczogW11cclxufSlcclxuZXhwb3J0IGNsYXNzIE1lbnVDb21wb25lbnQge1xyXG5cclxuICBjb25zdHJ1Y3RvciAoXHJcbiAgICBwcml2YXRlIHNlY3Rpb25TZXJ2aWNlOlNlY3Rpb25TZXJ2aWNlXHJcbiAgKSB7fVxyXG5cclxuICBhZGROYW1lKCkge1xyXG4gICAgdGhpcy5zZWN0aW9uU2VydmljZS5sZWZ0U2VjdGlvbi5vcGVuTmF2aWdhdGlvbkd1aWRlbGluZVRhYihcImRkXCIpO1xyXG4gIH1cclxuXHJcbn1cclxuIl19
