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
var NavigationGuidelineTab = (function (_super) {
    __extends(NavigationGuidelineTab, _super);
    function NavigationGuidelineTab() {
        _super.apply(this, arguments);
    }
    NavigationGuidelineTab = __decorate([
        core_1.Component({
            selector: 'test-tab',
            template: "\n        <tab heading=\"Usability guidelines22\" [removable]=\"true\"\n        (removed)=\"onRemove()\"\n        (select)=\"onSelect()\"\n        [active]=\"active\"\n        [hidden]=\"!active\">      \n            <guideline-view></guideline-view>\n        </tab>"
        }), 
        __metadata('design:paramtypes', [])
    ], NavigationGuidelineTab);
    return NavigationGuidelineTab;
}(tab_component_1.TabComponent));
exports.NavigationGuidelineTab = NavigationGuidelineTab;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvbmF2aWdhdGlvbi1ndWlkZWxpbmUtdGFiLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7QUFBQSxxQkFBd0IsZUFBZSxDQUFDLENBQUE7QUFDeEMsOEJBQTJCLGlCQUFpQixDQUFDLENBQUE7QUFhN0M7SUFBNEMsMENBQVk7SUFBeEQ7UUFBNEMsOEJBQVk7SUFFeEQsQ0FBQztJQWJEO1FBQUMsZ0JBQVMsQ0FBQztZQUNULFFBQVEsRUFBRSxVQUFVO1lBQ3BCLFFBQVEsRUFBRSw0UUFPRztTQUNkLENBQUM7OzhCQUFBO0lBR0YsNkJBQUM7QUFBRCxDQUZBLEFBRUMsQ0FGMkMsNEJBQVksR0FFdkQ7QUFGWSw4QkFBc0IseUJBRWxDLENBQUEiLCJmaWxlIjoiYXBwL2xheW91dC5jb250ZW50LnNlY3Rpb24udGFicy9uYXZpZ2F0aW9uLWd1aWRlbGluZS10YWIuY29tcG9uZW50LmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtDb21wb25lbnR9IGZyb20gXCJAYW5ndWxhci9jb3JlXCI7XG5pbXBvcnQge1RhYkNvbXBvbmVudH0gZnJvbSBcIi4vdGFiLmNvbXBvbmVudFwiO1xuXG5AQ29tcG9uZW50KHtcbiAgc2VsZWN0b3I6ICd0ZXN0LXRhYicsXG4gIHRlbXBsYXRlOiBgXG4gICAgICAgIDx0YWIgaGVhZGluZz1cIlVzYWJpbGl0eSBndWlkZWxpbmVzMjJcIiBbcmVtb3ZhYmxlXT1cInRydWVcIlxuICAgICAgICAocmVtb3ZlZCk9XCJvblJlbW92ZSgpXCJcbiAgICAgICAgKHNlbGVjdCk9XCJvblNlbGVjdCgpXCJcbiAgICAgICAgW2FjdGl2ZV09XCJhY3RpdmVcIlxuICAgICAgICBbaGlkZGVuXT1cIiFhY3RpdmVcIj4gICAgICBcbiAgICAgICAgICAgIDxndWlkZWxpbmUtdmlldz48L2d1aWRlbGluZS12aWV3PlxuICAgICAgICA8L3RhYj5gXG59KVxuZXhwb3J0IGNsYXNzIE5hdmlnYXRpb25HdWlkZWxpbmVUYWIgZXh0ZW5kcyBUYWJDb21wb25lbnQge1xuXG59XG4iXX0=
