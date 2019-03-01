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
var CreateGuidelineTab = (function (_super) {
    __extends(CreateGuidelineTab, _super);
    function CreateGuidelineTab() {
        _super.apply(this, arguments);
    }
    CreateGuidelineTab = __decorate([
        core_1.Component({
            template: "\n        <tab heading=\"Create new guideline\" [removable]=\"true\"\n        (removed)=\"onRemove()\"\n        (select)=\"onSelect()\"\n        [active]=\"active\"\n        [hidden]=\"!active\">      \n            <create-guideline></create-guideline>\n        </tab>",
        }), 
        __metadata('design:paramtypes', [])
    ], CreateGuidelineTab);
    return CreateGuidelineTab;
}(tab_component_1.TabComponent));
exports.CreateGuidelineTab = CreateGuidelineTab;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvZ3VpZGVsaW5lLWNyZWF0ZS10YWIuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7OztBQUFBLHFCQUF3QixlQUFlLENBQUMsQ0FBQTtBQUN4Qyw4QkFBMkIsaUJBQWlCLENBQUMsQ0FBQTtBQVk3QztJQUF5QyxzQ0FBWTtJQUFyRDtRQUF5Qyw4QkFBWTtJQUFFLENBQUM7SUFWeEQ7UUFBQyxnQkFBUyxDQUFDO1lBQ1QsUUFBUSxFQUFFLDhRQU9HO1NBQ2QsQ0FBQzs7MEJBQUE7SUFDcUQseUJBQUM7QUFBRCxDQUF2RCxBQUF3RCxDQUFmLDRCQUFZLEdBQUc7QUFBM0MsMEJBQWtCLHFCQUF5QixDQUFBIiwiZmlsZSI6ImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvZ3VpZGVsaW5lLWNyZWF0ZS10YWIuY29tcG9uZW50LmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtDb21wb25lbnR9IGZyb20gXCJAYW5ndWxhci9jb3JlXCI7XHJcbmltcG9ydCB7VGFiQ29tcG9uZW50fSBmcm9tIFwiLi90YWIuY29tcG9uZW50XCI7XHJcblxyXG5AQ29tcG9uZW50KHtcclxuICB0ZW1wbGF0ZTogYFxyXG4gICAgICAgIDx0YWIgaGVhZGluZz1cIkNyZWF0ZSBuZXcgZ3VpZGVsaW5lXCIgW3JlbW92YWJsZV09XCJ0cnVlXCJcclxuICAgICAgICAocmVtb3ZlZCk9XCJvblJlbW92ZSgpXCJcclxuICAgICAgICAoc2VsZWN0KT1cIm9uU2VsZWN0KClcIlxyXG4gICAgICAgIFthY3RpdmVdPVwiYWN0aXZlXCJcclxuICAgICAgICBbaGlkZGVuXT1cIiFhY3RpdmVcIj4gICAgICBcclxuICAgICAgICAgICAgPGNyZWF0ZS1ndWlkZWxpbmU+PC9jcmVhdGUtZ3VpZGVsaW5lPlxyXG4gICAgICAgIDwvdGFiPmAsXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBDcmVhdGVHdWlkZWxpbmVUYWIgIGV4dGVuZHMgVGFiQ29tcG9uZW50IHt9XHJcbiJdfQ==
