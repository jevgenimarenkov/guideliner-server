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
var guideline_1 = require("../guideline.view/guideline");
var http_1 = require("@angular/http");
var modal_component_1 = require("ng2-bootstrap/components/modal/modal.component");
var core_2 = require('@angular/core');
var components_helper_service_1 = require('ng2-bootstrap/components/utils/components-helper.service');
var GuidelineStaticEvaluationResultComponent = (function () {
    function GuidelineStaticEvaluationResultComponent(http, componentsHelper, vcr) {
        this.http = http;
        this.componentsHelper = componentsHelper;
        this.vcr = vcr;
        this.results = new Array();
        this.activeResult = new guideline_1.EvaluationResult();
        this.summary = [];
        componentsHelper.setRootViewContainerRef(vcr);
    }
    GuidelineStaticEvaluationResultComponent.prototype.showChildModal = function (result) {
        console.log(result);
        this.activeResult = result;
        this.childModal.show();
    };
    GuidelineStaticEvaluationResultComponent.prototype.hideChildModal = function () {
        this.childModal.hide();
    };
    GuidelineStaticEvaluationResultComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.get().subscribe(function (results) {
            _this.results = results;
            _this.summary = _this.calculateSummary(_this.results);
        });
    };
    GuidelineStaticEvaluationResultComponent.prototype.get = function () {
        var url = "http://localhost:8080/results";
        return this.http.get(url).map(function (resp) { return resp.json(); });
    };
    GuidelineStaticEvaluationResultComponent.prototype.getClassForPanel = function (result) {
        var clazz = "success";
        if (result == "FAIL")
            clazz = "danger";
        return "panel panel-" + clazz;
    };
    GuidelineStaticEvaluationResultComponent.prototype.getClassForLabel = function (result) {
        var clazz = "success";
        if (result == "FAIL")
            clazz = "danger";
        return "label label-" + clazz;
    };
    GuidelineStaticEvaluationResultComponent.prototype.calculateSummary = function (results) {
        var amountOfFailed = 0;
        var amountOfSuccess = 0;
        amountOfFailed = results.filter(function (res) { return res.result == "FAIL"; }).length;
        amountOfSuccess = results.filter(function (res) { return res.result == "SUCCESS"; }).length;
        this.summary = [];
        this.summary.push({
            value: 100 * amountOfFailed / (amountOfFailed + amountOfSuccess),
            type: 'danger'
        });
        this.summary.push({
            value: 100 * amountOfSuccess / (amountOfFailed + amountOfSuccess),
            type: 'success'
        });
        return this.summary;
    };
    __decorate([
        core_1.ViewChild('childModal'), 
        __metadata('design:type', modal_component_1.ModalDirective)
    ], GuidelineStaticEvaluationResultComponent.prototype, "childModal", void 0);
    GuidelineStaticEvaluationResultComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'static-evaluation-results',
            templateUrl: 'static-evaluation-results.component.html',
            providers: [],
            pipes: []
        }), 
        __metadata('design:paramtypes', [http_1.Http, components_helper_service_1.ComponentsHelper, core_2.ViewContainerRef])
    ], GuidelineStaticEvaluationResultComponent);
    return GuidelineStaticEvaluationResultComponent;
}());
exports.GuidelineStaticEvaluationResultComponent = GuidelineStaticEvaluationResultComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUuc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy9zdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQTJDLGVBQWUsQ0FBQyxDQUFBO0FBQzNELDBCQUErQiw2QkFBNkIsQ0FBQyxDQUFBO0FBRTdELHFCQUFtQixlQUFlLENBQUMsQ0FBQTtBQUNuQyxnQ0FBNkIsZ0RBQWdELENBQUMsQ0FBQTtBQUM5RSxxQkFBaUMsZUFBZSxDQUFDLENBQUE7QUFDakQsMENBQWlDLDBEQUEwRCxDQUFDLENBQUE7QUFVNUY7SUFVRSxrREFBb0IsSUFBUyxFQUFVLGdCQUFrQyxFQUFVLEdBQXFCO1FBQXBGLFNBQUksR0FBSixJQUFJLENBQUs7UUFBVSxxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQWtCO1FBQVUsUUFBRyxHQUFILEdBQUcsQ0FBa0I7UUFSakcsWUFBTyxHQUEyQixJQUFJLEtBQUssRUFBb0IsQ0FBQztRQUloRSxpQkFBWSxHQUFvQixJQUFJLDRCQUFnQixFQUFFLENBQUM7UUFFdkQsWUFBTyxHQUFTLEVBQUUsQ0FBQztRQUd4QixnQkFBZ0IsQ0FBQyx1QkFBdUIsQ0FBQyxHQUFHLENBQUMsQ0FBQztJQUNoRCxDQUFDO0lBRU0saUVBQWMsR0FBckIsVUFBc0IsTUFBeUI7UUFDN0MsT0FBTyxDQUFDLEdBQUcsQ0FBQyxNQUFNLENBQUMsQ0FBQztRQUNwQixJQUFJLENBQUMsWUFBWSxHQUFHLE1BQU0sQ0FBQztRQUMzQixJQUFJLENBQUMsVUFBVSxDQUFDLElBQUksRUFBRSxDQUFDO0lBQ3pCLENBQUM7SUFFTSxpRUFBYyxHQUFyQjtRQUNFLElBQUksQ0FBQyxVQUFVLENBQUMsSUFBSSxFQUFFLENBQUM7SUFDekIsQ0FBQztJQVdELDJEQUFRLEdBQVI7UUFBQSxpQkFXQztRQVZDLElBQUksQ0FBQyxHQUFHLEVBQUUsQ0FBQyxTQUFTLENBQUMsVUFBQSxPQUFPO1lBQzFCLEtBQUksQ0FBQyxPQUFPLEdBQUcsT0FBTyxDQUFDO1lBQ3ZCLEtBQUksQ0FBQyxPQUFPLEdBQUcsS0FBSSxDQUFDLGdCQUFnQixDQUFDLEtBQUksQ0FBQyxPQUFPLENBQUMsQ0FBQztRQUNyRCxDQUFDLENBQUMsQ0FBQTtJQU9KLENBQUM7SUFFRCxzREFBRyxHQUFIO1FBQ0UsSUFBSSxHQUFHLEdBQVUsK0JBQStCLENBQUM7UUFDakQsTUFBTSxDQUFDLElBQUksQ0FBQyxJQUFJLENBQUMsR0FBRyxDQUFDLEdBQUcsQ0FBQyxDQUFDLEdBQUcsQ0FBQyxVQUFBLElBQUksSUFBSSxPQUFBLElBQUksQ0FBQyxJQUFJLEVBQUUsRUFBWCxDQUFXLENBQUMsQ0FBQztJQUNyRCxDQUFDO0lBRUQsbUVBQWdCLEdBQWhCLFVBQWlCLE1BQWU7UUFDOUIsSUFBSSxLQUFLLEdBQVUsU0FBUyxDQUFDO1FBQzdCLEVBQUUsQ0FBQyxDQUFDLE1BQU0sSUFBSSxNQUFNLENBQUM7WUFBQyxLQUFLLEdBQUcsUUFBUSxDQUFDO1FBQ3ZDLE1BQU0sQ0FBQyxjQUFjLEdBQUcsS0FBSyxDQUFDO0lBQ2hDLENBQUM7SUFFRCxtRUFBZ0IsR0FBaEIsVUFBaUIsTUFBZTtRQUM5QixJQUFJLEtBQUssR0FBVSxTQUFTLENBQUM7UUFDN0IsRUFBRSxDQUFDLENBQUMsTUFBTSxJQUFJLE1BQU0sQ0FBQztZQUFDLEtBQUssR0FBRyxRQUFRLENBQUM7UUFDdkMsTUFBTSxDQUFDLGNBQWMsR0FBRyxLQUFLLENBQUM7SUFDaEMsQ0FBQztJQUVPLG1FQUFnQixHQUF4QixVQUF5QixPQUFnQztRQUN2RCxJQUFJLGNBQWMsR0FBWSxDQUFDLENBQUE7UUFDL0IsSUFBSSxlQUFlLEdBQVksQ0FBQyxDQUFDO1FBQ2pDLGNBQWMsR0FBRyxPQUFPLENBQUMsTUFBTSxDQUFDLFVBQUEsR0FBRyxJQUFJLE9BQUEsR0FBRyxDQUFDLE1BQU0sSUFBSSxNQUFNLEVBQXBCLENBQW9CLENBQUMsQ0FBQyxNQUFNLENBQUM7UUFDcEUsZUFBZSxHQUFHLE9BQU8sQ0FBQyxNQUFNLENBQUMsVUFBQSxHQUFHLElBQUksT0FBQSxHQUFHLENBQUMsTUFBTSxJQUFJLFNBQVMsRUFBdkIsQ0FBdUIsQ0FBQyxDQUFDLE1BQU0sQ0FBQztRQUV4RSxJQUFJLENBQUMsT0FBTyxHQUFHLEVBQUUsQ0FBQztRQUNsQixJQUFJLENBQUMsT0FBTyxDQUFDLElBQUksQ0FBQztZQUNoQixLQUFLLEVBQUUsR0FBRyxHQUFDLGNBQWMsR0FBQyxDQUFDLGNBQWMsR0FBRyxlQUFlLENBQUM7WUFDNUQsSUFBSSxFQUFFLFFBQVE7U0FDZixDQUFDLENBQUM7UUFFSCxJQUFJLENBQUMsT0FBTyxDQUFDLElBQUksQ0FBQztZQUNoQixLQUFLLEVBQUUsR0FBRyxHQUFDLGVBQWUsR0FBQyxDQUFDLGNBQWMsR0FBRyxlQUFlLENBQUM7WUFDN0QsSUFBSSxFQUFFLFNBQVM7U0FDaEIsQ0FBQyxDQUFDO1FBRUgsTUFBTSxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUM7SUFDdEIsQ0FBQztJQTdFRDtRQUFDLGdCQUFTLENBQUMsWUFBWSxDQUFDOztnRkFBQTtJQVgxQjtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsTUFBTSxDQUFDLEVBQUU7WUFDbkIsUUFBUSxFQUFFLDJCQUEyQjtZQUNyQyxXQUFXLEVBQUUsMENBQTBDO1lBQ3ZELFNBQVMsRUFBRSxFQUFFO1lBQ2IsS0FBSyxFQUFFLEVBQUU7U0FDVixDQUFDOztnREFBQTtJQW9GRiwrQ0FBQztBQUFELENBbkZBLEFBbUZDLElBQUE7QUFuRlksZ0RBQXdDLDJDQW1GcEQsQ0FBQSIsImZpbGUiOiJhcHAvZ3VpZGVsaW5lLnN0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMvc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudCwgT25Jbml0LCBWaWV3Q2hpbGR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge0V2YWx1YXRpb25SZXN1bHR9IGZyb20gXCIuLi9ndWlkZWxpbmUudmlldy9ndWlkZWxpbmVcIjtcclxuaW1wb3J0IHtPYnNlcnZhYmxlfSBmcm9tIFwicnhqc1wiO1xyXG5pbXBvcnQge0h0dHB9IGZyb20gXCJAYW5ndWxhci9odHRwXCI7XHJcbmltcG9ydCB7TW9kYWxEaXJlY3RpdmV9IGZyb20gXCJuZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvbW9kYWwvbW9kYWwuY29tcG9uZW50XCI7XHJcbmltcG9ydCB7IFZpZXdDb250YWluZXJSZWYgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHsgQ29tcG9uZW50c0hlbHBlciB9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy91dGlscy9jb21wb25lbnRzLWhlbHBlci5zZXJ2aWNlJztcclxuaW1wb3J0IHtJbnB1dH0gZnJvbSBcIkBhbmd1bGFyL2NvcmUvc3JjL21ldGFkYXRhL2RpcmVjdGl2ZXNcIjtcclxuXHJcbkBDb21wb25lbnQoe1xyXG4gIG1vZHVsZUlkOiBtb2R1bGUuaWQsXHJcbiAgc2VsZWN0b3I6ICdzdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzJyxcclxuICB0ZW1wbGF0ZVVybDogJ3N0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMuY29tcG9uZW50Lmh0bWwnLFxyXG4gIHByb3ZpZGVyczogW10sXHJcbiAgcGlwZXM6IFtdXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBHdWlkZWxpbmVTdGF0aWNFdmFsdWF0aW9uUmVzdWx0Q29tcG9uZW50IGltcGxlbWVudHMgT25Jbml0IHtcclxuXHJcbiAgcHVibGljIHJlc3VsdHM6QXJyYXk8RXZhbHVhdGlvblJlc3VsdD4gPSBuZXcgQXJyYXk8RXZhbHVhdGlvblJlc3VsdD4oKTtcclxuXHJcbiAgQFZpZXdDaGlsZCgnY2hpbGRNb2RhbCcpIHB1YmxpYyBjaGlsZE1vZGFsOk1vZGFsRGlyZWN0aXZlO1xyXG5cclxuICBwdWJsaWMgYWN0aXZlUmVzdWx0OkV2YWx1YXRpb25SZXN1bHQgPSBuZXcgRXZhbHVhdGlvblJlc3VsdCgpO1xyXG5cclxuICBwdWJsaWMgc3VtbWFyeTphbnlbXSA9IFtdO1xyXG5cclxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIGh0dHA6SHR0cCwgcHJpdmF0ZSBjb21wb25lbnRzSGVscGVyOiBDb21wb25lbnRzSGVscGVyLCBwcml2YXRlIHZjcjogVmlld0NvbnRhaW5lclJlZikge1xyXG4gICAgY29tcG9uZW50c0hlbHBlci5zZXRSb290Vmlld0NvbnRhaW5lclJlZih2Y3IpO1xyXG4gIH1cclxuXHJcbiAgcHVibGljIHNob3dDaGlsZE1vZGFsKHJlc3VsdCA6IEV2YWx1YXRpb25SZXN1bHQpOnZvaWQge1xyXG4gICAgY29uc29sZS5sb2cocmVzdWx0KTtcclxuICAgIHRoaXMuYWN0aXZlUmVzdWx0ID0gcmVzdWx0O1xyXG4gICAgdGhpcy5jaGlsZE1vZGFsLnNob3coKTtcclxuICB9XHJcblxyXG4gIHB1YmxpYyBoaWRlQ2hpbGRNb2RhbCgpOnZvaWQge1xyXG4gICAgdGhpcy5jaGlsZE1vZGFsLmhpZGUoKTtcclxuICB9XHJcblxyXG4gIC8vIG5nT25Jbml0KCk6IHZvaWQge1xyXG4gIC8vICBmb3IgKHZhciBpID0gMDsgaSA8IDI7IGkrKykge1xyXG4gIC8vICAgICBsZXQgZ3VpZGVsaW5lOkV2YWx1YXRpb25SZXN1bHQgPSBuZXcgRXZhbHVhdGlvblJlc3VsdCgpO1xyXG4gIC8vICAgICBndWlkZWxpbmUubmFtZSA9IFwiNzoyIERpZmZlcmVudGlhdGUgYW5kIEdyb3VwIE5hdmlnYXRpb24gRWxlbWVudHNcIjtcclxuICAvLyAgICAgZ3VpZGVsaW5lLmRlc2NyaXB0aW9uID0gXCJDbGVhcmx5IGRpZmZlcmVudGlhdGUgbmF2aWdhdGlvbiBlbGVtZW50cyBmcm9tIG9uZSBhbm90aGVyLCBidXQgZ3JvdXAgYW5kIHBsYWNlIHRoZW0gaW4gYSBjb25zaXN0ZW50IGFuZCBlYXN5IHRvIGZpbmQgcGxhY2Ugb24gZWFjaCBwYWdlLlwiO1xyXG4gIC8vICAgICB0aGlzLnJlc3VsdHMucHVzaChndWlkZWxpbmUpO1xyXG4gIC8vICB9XHJcbiAgLy8gfVxyXG5cclxuICBuZ09uSW5pdCgpOiB2b2lkIHtcclxuICAgIHRoaXMuZ2V0KCkuc3Vic2NyaWJlKHJlc3VsdHMgPT4ge1xyXG4gICAgICB0aGlzLnJlc3VsdHMgPSByZXN1bHRzO1xyXG4gICAgICB0aGlzLnN1bW1hcnkgPSB0aGlzLmNhbGN1bGF0ZVN1bW1hcnkodGhpcy5yZXN1bHRzKTtcclxuICAgIH0pXHJcbiAgICAvLyBmb3IgKHZhciBpID0gMDsgaSA8IDI7IGkrKykge1xyXG4gICAgLy8gICAgbGV0IGd1aWRlbGluZTpHdWlkZWxpbmUgPSBuZXcgR3VpZGVsaW5lKCk7XHJcbiAgICAvLyAgICBndWlkZWxpbmUubmFtZSA9IFwiNzoyIERpZmZlcmVudGlhdGUgYW5kIEdyb3VwIE5hdmlnYXRpb24gRWxlbWVudHNcIjtcclxuICAgIC8vICAgIGd1aWRlbGluZS5kZXNjcmlwdGlvbiA9IFwiQ2xlYXJseSBkaWZmZXJlbnRpYXRlIG5hdmlnYXRpb24gZWxlbWVudHMgZnJvbSBvbmUgYW5vdGhlciwgYnV0IGdyb3VwIGFuZCBwbGFjZSB0aGVtIGluIGEgY29uc2lzdGVudCBhbmQgZWFzeSB0byBmaW5kIHBsYWNlIG9uIGVhY2ggcGFnZS5cIjtcclxuICAgIC8vICAgIHRoaXMuZ3VpZGVsaW5lcy5wdXNoKGd1aWRlbGluZSk7XHJcbiAgICAvLyB9XHJcbiAgfVxyXG5cclxuICBnZXQoKTpPYnNlcnZhYmxlPGFueT4ge1xyXG4gICAgbGV0IHVybDpzdHJpbmcgPSBgaHR0cDovL2xvY2FsaG9zdDo4MDgwL3Jlc3VsdHNgO1xyXG4gICAgcmV0dXJuIHRoaXMuaHR0cC5nZXQodXJsKS5tYXAocmVzcCA9PiByZXNwLmpzb24oKSk7XHJcbiAgfVxyXG5cclxuICBnZXRDbGFzc0ZvclBhbmVsKHJlc3VsdCA6IFN0cmluZyk6U3RyaW5nIHtcclxuICAgIGxldCBjbGF6ejpTdHJpbmcgPSBcInN1Y2Nlc3NcIjtcclxuICAgIGlmIChyZXN1bHQgPT0gXCJGQUlMXCIpIGNsYXp6ID0gXCJkYW5nZXJcIjtcclxuICAgIHJldHVybiBcInBhbmVsIHBhbmVsLVwiICsgY2xheno7XHJcbiAgfVxyXG5cclxuICBnZXRDbGFzc0ZvckxhYmVsKHJlc3VsdCA6IFN0cmluZyk6U3RyaW5nIHtcclxuICAgIGxldCBjbGF6ejpTdHJpbmcgPSBcInN1Y2Nlc3NcIjtcclxuICAgIGlmIChyZXN1bHQgPT0gXCJGQUlMXCIpIGNsYXp6ID0gXCJkYW5nZXJcIjtcclxuICAgIHJldHVybiBcImxhYmVsIGxhYmVsLVwiICsgY2xheno7XHJcbiAgfVxyXG5cclxuICBwcml2YXRlIGNhbGN1bGF0ZVN1bW1hcnkocmVzdWx0czogQXJyYXk8RXZhbHVhdGlvblJlc3VsdD4pIDogYW55W10ge1xyXG4gICAgbGV0IGFtb3VudE9mRmFpbGVkIDogbnVtYmVyID0gMFxyXG4gICAgbGV0IGFtb3VudE9mU3VjY2VzcyA6IG51bWJlciA9IDA7XHJcbiAgICBhbW91bnRPZkZhaWxlZCA9IHJlc3VsdHMuZmlsdGVyKHJlcyA9PiByZXMucmVzdWx0ID09IFwiRkFJTFwiKS5sZW5ndGg7XHJcbiAgICBhbW91bnRPZlN1Y2Nlc3MgPSByZXN1bHRzLmZpbHRlcihyZXMgPT4gcmVzLnJlc3VsdCA9PSBcIlNVQ0NFU1NcIikubGVuZ3RoO1xyXG5cclxuICAgIHRoaXMuc3VtbWFyeSA9IFtdO1xyXG4gICAgdGhpcy5zdW1tYXJ5LnB1c2goe1xyXG4gICAgICB2YWx1ZTogMTAwKmFtb3VudE9mRmFpbGVkLyhhbW91bnRPZkZhaWxlZCArIGFtb3VudE9mU3VjY2VzcyksXHJcbiAgICAgIHR5cGU6ICdkYW5nZXInXHJcbiAgICB9KTtcclxuXHJcbiAgICB0aGlzLnN1bW1hcnkucHVzaCh7XHJcbiAgICAgIHZhbHVlOiAxMDAqYW1vdW50T2ZTdWNjZXNzLyhhbW91bnRPZkZhaWxlZCArIGFtb3VudE9mU3VjY2VzcyksXHJcbiAgICAgIHR5cGU6ICdzdWNjZXNzJ1xyXG4gICAgfSk7XHJcblxyXG4gICAgcmV0dXJuIHRoaXMuc3VtbWFyeTtcclxuICB9XHJcblxyXG59XHJcbiJdfQ==
