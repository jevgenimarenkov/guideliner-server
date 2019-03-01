"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var tab_component_1 = require("./tab.component");
var GuidelineSelectCategoriesTab = (function (_super) {
    __extends(GuidelineSelectCategoriesTab, _super);
    function GuidelineSelectCategoriesTab() {
        _super.apply(this, arguments);
    }
    GuidelineSelectCategoriesTab = __decorate([
        core_1.Component({
            template: "\n        <tab heading=\"Guideline categories\" [removable]=\"true\"\n        (removed)=\"onRemove()\"\n        (select)=\"onSelect()\"\n        [active]=\"active\"\n        [hidden]=\"!active\">      \n            <categorised-guideline>\n          </categorised-guideline>\n        </tab>"
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineSelectCategoriesTab);
    return GuidelineSelectCategoriesTab;
}(tab_component_1.TabComponent));
exports.GuidelineSelectCategoriesTab = GuidelineSelectCategoriesTab;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvZ3VpZGVsaW5lLXNlbGVjdC1jYXRlZ29yaWVzLXRhYi5jb21wb25lbnQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7O0FBQUEscUJBQXdCLGVBQWUsQ0FBQyxDQUFBO0FBQ3hDLDhCQUEyQixpQkFBaUIsQ0FBQyxDQUFBO0FBYTdDO0lBQWtELGdEQUFZO0lBQTlEO1FBQWtELDhCQUFZO0lBQUUsQ0FBQztJQVhqRTtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsb1NBUUc7U0FDZCxDQUFDOztvQ0FBQTtJQUM4RCxtQ0FBQztBQUFELENBQWhFLEFBQWlFLENBQWYsNEJBQVksR0FBRztBQUFwRCxvQ0FBNEIsK0JBQXdCLENBQUEiLCJmaWxlIjoiYXBwL2xheW91dC5jb250ZW50LnNlY3Rpb24udGFicy9ndWlkZWxpbmUtc2VsZWN0LWNhdGVnb3JpZXMtdGFiLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50fSBmcm9tIFwiQGFuZ3VsYXIvY29yZVwiO1xyXG5pbXBvcnQge1RhYkNvbXBvbmVudH0gZnJvbSBcIi4vdGFiLmNvbXBvbmVudFwiO1xyXG5cclxuQENvbXBvbmVudCh7XHJcbiAgdGVtcGxhdGU6IGBcclxuICAgICAgICA8dGFiIGhlYWRpbmc9XCJHdWlkZWxpbmUgY2F0ZWdvcmllc1wiIFtyZW1vdmFibGVdPVwidHJ1ZVwiXHJcbiAgICAgICAgKHJlbW92ZWQpPVwib25SZW1vdmUoKVwiXHJcbiAgICAgICAgKHNlbGVjdCk9XCJvblNlbGVjdCgpXCJcclxuICAgICAgICBbYWN0aXZlXT1cImFjdGl2ZVwiXHJcbiAgICAgICAgW2hpZGRlbl09XCIhYWN0aXZlXCI+ICAgICAgXHJcbiAgICAgICAgICAgIDxjYXRlZ29yaXNlZC1ndWlkZWxpbmU+XHJcbiAgICAgICAgICA8L2NhdGVnb3Jpc2VkLWd1aWRlbGluZT5cclxuICAgICAgICA8L3RhYj5gXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBHdWlkZWxpbmVTZWxlY3RDYXRlZ29yaWVzVGFiIGV4dGVuZHMgVGFiQ29tcG9uZW50IHt9XHJcbiJdfQ==
