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
var GuidelineEvaluateTab = (function (_super) {
    __extends(GuidelineEvaluateTab, _super);
    function GuidelineEvaluateTab() {
        _super.apply(this, arguments);
    }
    GuidelineEvaluateTab = __decorate([
        core_1.Component({
            template: "\n        <tab heading=\"Automatic Evaluation results\" [removable]=\"true\"\n        (removed)=\"onRemove()\"\n        (select)=\"onSelect()\"\n        [active]=\"active\"\n        [hidden]=\"!active\">      \n            <guideline-evaluate\n            [category] = 'model'>\n          </guideline-evaluate>\n        </tab>"
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineEvaluateTab);
    return GuidelineEvaluateTab;
}(tab_component_1.TabComponent));
exports.GuidelineEvaluateTab = GuidelineEvaluateTab;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvZ3VpZGVsaW5lLWV2YWx1YXRlLXRhYi5jb21wb25lbnQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7O0FBQUEscUJBQXdCLGVBQWUsQ0FBQyxDQUFBO0FBQ3hDLDhCQUEyQixpQkFBaUIsQ0FBQyxDQUFBO0FBYzdDO0lBQTBDLHdDQUFZO0lBQXREO1FBQTBDLDhCQUFZO0lBQUUsQ0FBQztJQVp6RDtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsd1VBU0c7U0FDZCxDQUFDOzs0QkFBQTtJQUNzRCwyQkFBQztBQUFELENBQXhELEFBQXlELENBQWYsNEJBQVksR0FBRztBQUE1Qyw0QkFBb0IsdUJBQXdCLENBQUEiLCJmaWxlIjoiYXBwL2xheW91dC5jb250ZW50LnNlY3Rpb24udGFicy9ndWlkZWxpbmUtZXZhbHVhdGUtdGFiLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50fSBmcm9tIFwiQGFuZ3VsYXIvY29yZVwiO1xyXG5pbXBvcnQge1RhYkNvbXBvbmVudH0gZnJvbSBcIi4vdGFiLmNvbXBvbmVudFwiO1xyXG5cclxuQENvbXBvbmVudCh7XHJcbiAgdGVtcGxhdGU6IGBcclxuICAgICAgICA8dGFiIGhlYWRpbmc9XCJBdXRvbWF0aWMgRXZhbHVhdGlvbiByZXN1bHRzXCIgW3JlbW92YWJsZV09XCJ0cnVlXCJcclxuICAgICAgICAocmVtb3ZlZCk9XCJvblJlbW92ZSgpXCJcclxuICAgICAgICAoc2VsZWN0KT1cIm9uU2VsZWN0KClcIlxyXG4gICAgICAgIFthY3RpdmVdPVwiYWN0aXZlXCJcclxuICAgICAgICBbaGlkZGVuXT1cIiFhY3RpdmVcIj4gICAgICBcclxuICAgICAgICAgICAgPGd1aWRlbGluZS1ldmFsdWF0ZVxyXG4gICAgICAgICAgICBbY2F0ZWdvcnldID0gJ21vZGVsJz5cclxuICAgICAgICAgIDwvZ3VpZGVsaW5lLWV2YWx1YXRlPlxyXG4gICAgICAgIDwvdGFiPmBcclxufSlcclxuZXhwb3J0IGNsYXNzIEd1aWRlbGluZUV2YWx1YXRlVGFiIGV4dGVuZHMgVGFiQ29tcG9uZW50IHt9XHJcbiJdfQ==
