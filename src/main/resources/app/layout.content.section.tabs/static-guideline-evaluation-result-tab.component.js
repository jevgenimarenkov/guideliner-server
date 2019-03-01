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
var GuidelineEvaluationResultsTab = (function (_super) {
    __extends(GuidelineEvaluationResultsTab, _super);
    function GuidelineEvaluationResultsTab() {
        _super.apply(this, arguments);
    }
    GuidelineEvaluationResultsTab = __decorate([
        core_1.Component({
            template: "\n        <tab heading=\"Existing Evaluation results\" [removable]=\"true\"\n        (removed)=\"onRemove()\"\n        (select)=\"onSelect()\"\n        [active]=\"active\"\n        [hidden]=\"!active\">      \n            <static-evaluation-results></static-evaluation-results>\n        </tab>",
        }), 
        __metadata('design:paramtypes', [])
    ], GuidelineEvaluationResultsTab);
    return GuidelineEvaluationResultsTab;
}(tab_component_1.TabComponent));
exports.GuidelineEvaluationResultsTab = GuidelineEvaluationResultsTab;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvc3RhdGljLWd1aWRlbGluZS1ldmFsdWF0aW9uLXJlc3VsdC10YWIuY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7OztBQUFBLHFCQUF3QixlQUFlLENBQUMsQ0FBQTtBQUN4Qyw4QkFBMkIsaUJBQWlCLENBQUMsQ0FBQTtBQVk3QztJQUFtRCxpREFBWTtJQUEvRDtRQUFtRCw4QkFBWTtJQUFFLENBQUM7SUFWbEU7UUFBQyxnQkFBUyxDQUFDO1lBQ1QsUUFBUSxFQUFFLHVTQU9HO1NBQ2QsQ0FBQzs7cUNBQUE7SUFDK0Qsb0NBQUM7QUFBRCxDQUFqRSxBQUFrRSxDQUFmLDRCQUFZLEdBQUc7QUFBckQscUNBQTZCLGdDQUF3QixDQUFBIiwiZmlsZSI6ImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvc3RhdGljLWd1aWRlbGluZS1ldmFsdWF0aW9uLXJlc3VsdC10YWIuY29tcG9uZW50LmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtDb21wb25lbnR9IGZyb20gXCJAYW5ndWxhci9jb3JlXCI7XHJcbmltcG9ydCB7VGFiQ29tcG9uZW50fSBmcm9tIFwiLi90YWIuY29tcG9uZW50XCI7XHJcblxyXG5AQ29tcG9uZW50KHtcclxuICB0ZW1wbGF0ZTogYFxyXG4gICAgICAgIDx0YWIgaGVhZGluZz1cIkV4aXN0aW5nIEV2YWx1YXRpb24gcmVzdWx0c1wiIFtyZW1vdmFibGVdPVwidHJ1ZVwiXHJcbiAgICAgICAgKHJlbW92ZWQpPVwib25SZW1vdmUoKVwiXHJcbiAgICAgICAgKHNlbGVjdCk9XCJvblNlbGVjdCgpXCJcclxuICAgICAgICBbYWN0aXZlXT1cImFjdGl2ZVwiXHJcbiAgICAgICAgW2hpZGRlbl09XCIhYWN0aXZlXCI+ICAgICAgXHJcbiAgICAgICAgICAgIDxzdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzPjwvc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cz5cclxuICAgICAgICA8L3RhYj5gLFxyXG59KVxyXG5leHBvcnQgY2xhc3MgR3VpZGVsaW5lRXZhbHVhdGlvblJlc3VsdHNUYWIgZXh0ZW5kcyBUYWJDb21wb25lbnQge31cclxuIl19
