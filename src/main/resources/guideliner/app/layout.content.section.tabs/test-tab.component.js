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
var TestTabComponent = (function (_super) {
    __extends(TestTabComponent, _super);
    function TestTabComponent() {
        _super.apply(this, arguments);
    }
    TestTabComponent = __decorate([
        core_1.Component({
            selector: 'test-tab',
            template: "\n        <tab heading=\"Component\" [removable]='true'\n        (removed)='onRemove()'\n        (select)='onSelect()'\n        [active]='active'\n        [hidden]='!active'>\n        <div class=\"panel\">\n  <div class=\"panel-body\">\n  Ha hah h\n  </div>\n  </div>\n        </tab>"
        }), 
        __metadata('design:paramtypes', [])
    ], TestTabComponent);
    return TestTabComponent;
}(tab_component_1.TabComponent));
exports.TestTabComponent = TestTabComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvdGVzdC10YWIuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7OztBQUFBLHFCQUF3QixlQUFlLENBQUMsQ0FBQTtBQUN4Qyw4QkFBMkIsaUJBQWlCLENBQUMsQ0FBQTtBQWlCN0M7SUFBc0Msb0NBQVk7SUFBbEQ7UUFBc0MsOEJBQVk7SUFFbEQsQ0FBQztJQWpCRDtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsVUFBVTtZQUNwQixRQUFRLEVBQUUsNlJBV0c7U0FDZCxDQUFDOzt3QkFBQTtJQUdGLHVCQUFDO0FBQUQsQ0FGQSxBQUVDLENBRnFDLDRCQUFZLEdBRWpEO0FBRlksd0JBQWdCLG1CQUU1QixDQUFBIiwiZmlsZSI6ImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvdGVzdC10YWIuY29tcG9uZW50LmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtDb21wb25lbnR9IGZyb20gXCJAYW5ndWxhci9jb3JlXCI7XHJcbmltcG9ydCB7VGFiQ29tcG9uZW50fSBmcm9tIFwiLi90YWIuY29tcG9uZW50XCI7XHJcblxyXG5AQ29tcG9uZW50KHtcclxuICBzZWxlY3RvcjogJ3Rlc3QtdGFiJyxcclxuICB0ZW1wbGF0ZTogYFxyXG4gICAgICAgIDx0YWIgaGVhZGluZz1cIkNvbXBvbmVudFwiIFtyZW1vdmFibGVdPSd0cnVlJ1xyXG4gICAgICAgIChyZW1vdmVkKT0nb25SZW1vdmUoKSdcclxuICAgICAgICAoc2VsZWN0KT0nb25TZWxlY3QoKSdcclxuICAgICAgICBbYWN0aXZlXT0nYWN0aXZlJ1xyXG4gICAgICAgIFtoaWRkZW5dPSchYWN0aXZlJz5cclxuICAgICAgICA8ZGl2IGNsYXNzPVwicGFuZWxcIj5cclxuICA8ZGl2IGNsYXNzPVwicGFuZWwtYm9keVwiPlxyXG4gIEhhIGhhaCBoXHJcbiAgPC9kaXY+XHJcbiAgPC9kaXY+XHJcbiAgICAgICAgPC90YWI+YFxyXG59KVxyXG5leHBvcnQgY2xhc3MgVGVzdFRhYkNvbXBvbmVudCBleHRlbmRzIFRhYkNvbXBvbmVudCB7XHJcblxyXG59XHJcbiJdfQ==
