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
    GuidelineStaticEvaluationResultComponent.prototype.showChildModal = function (event, result) {
        event.preventDefault();
        console.log("aa");
        console.log(event);
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

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUuc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy9zdGF0aWMtZXZhbHVhdGlvbi1yZXN1bHRzLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQTJDLGVBQWUsQ0FBQyxDQUFBO0FBQzNELDBCQUErQiw2QkFBNkIsQ0FBQyxDQUFBO0FBRTdELHFCQUFtQixlQUFlLENBQUMsQ0FBQTtBQUNuQyxnQ0FBNkIsZ0RBQWdELENBQUMsQ0FBQTtBQUM5RSxxQkFBaUMsZUFBZSxDQUFDLENBQUE7QUFDakQsMENBQWlDLDBEQUEwRCxDQUFDLENBQUE7QUFVNUY7SUFVRSxrREFBb0IsSUFBUyxFQUFVLGdCQUFrQyxFQUFVLEdBQXFCO1FBQXBGLFNBQUksR0FBSixJQUFJLENBQUs7UUFBVSxxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQWtCO1FBQVUsUUFBRyxHQUFILEdBQUcsQ0FBa0I7UUFSakcsWUFBTyxHQUEyQixJQUFJLEtBQUssRUFBb0IsQ0FBQztRQUloRSxpQkFBWSxHQUFvQixJQUFJLDRCQUFnQixFQUFFLENBQUM7UUFFdkQsWUFBTyxHQUFTLEVBQUUsQ0FBQztRQUd4QixnQkFBZ0IsQ0FBQyx1QkFBdUIsQ0FBQyxHQUFHLENBQUMsQ0FBQztJQUNoRCxDQUFDO0lBRU0saUVBQWMsR0FBckIsVUFBc0IsS0FBVyxFQUFFLE1BQXlCO1FBQzFELEtBQUssQ0FBQyxjQUFjLEVBQUUsQ0FBQztRQUN2QixPQUFPLENBQUMsR0FBRyxDQUFDLElBQUksQ0FBQyxDQUFDO1FBQ2xCLE9BQU8sQ0FBQyxHQUFHLENBQUMsS0FBSyxDQUFDLENBQUM7UUFDbkIsT0FBTyxDQUFDLEdBQUcsQ0FBQyxNQUFNLENBQUMsQ0FBQztRQUNwQixJQUFJLENBQUMsWUFBWSxHQUFHLE1BQU0sQ0FBQztRQUMzQixJQUFJLENBQUMsVUFBVSxDQUFDLElBQUksRUFBRSxDQUFDO0lBQ3pCLENBQUM7SUFFTSxpRUFBYyxHQUFyQjtRQUNFLElBQUksQ0FBQyxVQUFVLENBQUMsSUFBSSxFQUFFLENBQUM7SUFDekIsQ0FBQztJQVdELDJEQUFRLEdBQVI7UUFBQSxpQkFXQztRQVZDLElBQUksQ0FBQyxHQUFHLEVBQUUsQ0FBQyxTQUFTLENBQUMsVUFBQSxPQUFPO1lBQzFCLEtBQUksQ0FBQyxPQUFPLEdBQUcsT0FBTyxDQUFDO1lBQ3ZCLEtBQUksQ0FBQyxPQUFPLEdBQUcsS0FBSSxDQUFDLGdCQUFnQixDQUFDLEtBQUksQ0FBQyxPQUFPLENBQUMsQ0FBQztRQUNyRCxDQUFDLENBQUMsQ0FBQTtJQU9KLENBQUM7SUFFRCxzREFBRyxHQUFIO1FBQ0UsSUFBSSxHQUFHLEdBQVUsK0JBQStCLENBQUM7UUFDakQsTUFBTSxDQUFDLElBQUksQ0FBQyxJQUFJLENBQUMsR0FBRyxDQUFDLEdBQUcsQ0FBQyxDQUFDLEdBQUcsQ0FBQyxVQUFBLElBQUksSUFBSSxPQUFBLElBQUksQ0FBQyxJQUFJLEVBQUUsRUFBWCxDQUFXLENBQUMsQ0FBQztJQUNyRCxDQUFDO0lBRUQsbUVBQWdCLEdBQWhCLFVBQWlCLE1BQWU7UUFDOUIsSUFBSSxLQUFLLEdBQVUsU0FBUyxDQUFDO1FBQzdCLEVBQUUsQ0FBQyxDQUFDLE1BQU0sSUFBSSxNQUFNLENBQUM7WUFBQyxLQUFLLEdBQUcsUUFBUSxDQUFDO1FBQ3ZDLE1BQU0sQ0FBQyxjQUFjLEdBQUcsS0FBSyxDQUFDO0lBQ2hDLENBQUM7SUFFRCxtRUFBZ0IsR0FBaEIsVUFBaUIsTUFBZTtRQUM5QixJQUFJLEtBQUssR0FBVSxTQUFTLENBQUM7UUFDN0IsRUFBRSxDQUFDLENBQUMsTUFBTSxJQUFJLE1BQU0sQ0FBQztZQUFDLEtBQUssR0FBRyxRQUFRLENBQUM7UUFDdkMsTUFBTSxDQUFDLGNBQWMsR0FBRyxLQUFLLENBQUM7SUFDaEMsQ0FBQztJQUVPLG1FQUFnQixHQUF4QixVQUF5QixPQUFnQztRQUN2RCxJQUFJLGNBQWMsR0FBWSxDQUFDLENBQUE7UUFDL0IsSUFBSSxlQUFlLEdBQVksQ0FBQyxDQUFDO1FBQ2pDLGNBQWMsR0FBRyxPQUFPLENBQUMsTUFBTSxDQUFDLFVBQUEsR0FBRyxJQUFJLE9BQUEsR0FBRyxDQUFDLE1BQU0sSUFBSSxNQUFNLEVBQXBCLENBQW9CLENBQUMsQ0FBQyxNQUFNLENBQUM7UUFDcEUsZUFBZSxHQUFHLE9BQU8sQ0FBQyxNQUFNLENBQUMsVUFBQSxHQUFHLElBQUksT0FBQSxHQUFHLENBQUMsTUFBTSxJQUFJLFNBQVMsRUFBdkIsQ0FBdUIsQ0FBQyxDQUFDLE1BQU0sQ0FBQztRQUV4RSxJQUFJLENBQUMsT0FBTyxHQUFHLEVBQUUsQ0FBQztRQUNsQixJQUFJLENBQUMsT0FBTyxDQUFDLElBQUksQ0FBQztZQUNoQixLQUFLLEVBQUUsR0FBRyxHQUFDLGNBQWMsR0FBQyxDQUFDLGNBQWMsR0FBRyxlQUFlLENBQUM7WUFDNUQsSUFBSSxFQUFFLFFBQVE7U0FDZixDQUFDLENBQUM7UUFFSCxJQUFJLENBQUMsT0FBTyxDQUFDLElBQUksQ0FBQztZQUNoQixLQUFLLEVBQUUsR0FBRyxHQUFDLGVBQWUsR0FBQyxDQUFDLGNBQWMsR0FBRyxlQUFlLENBQUM7WUFDN0QsSUFBSSxFQUFFLFNBQVM7U0FDaEIsQ0FBQyxDQUFDO1FBRUgsTUFBTSxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUM7SUFDdEIsQ0FBQztJQWhGRDtRQUFDLGdCQUFTLENBQUMsWUFBWSxDQUFDOztnRkFBQTtJQVgxQjtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsTUFBTSxDQUFDLEVBQUU7WUFDbkIsUUFBUSxFQUFFLDJCQUEyQjtZQUNyQyxXQUFXLEVBQUUsMENBQTBDO1lBQ3ZELFNBQVMsRUFBRSxFQUFFO1lBQ2IsS0FBSyxFQUFFLEVBQUU7U0FDVixDQUFDOztnREFBQTtJQXVGRiwrQ0FBQztBQUFELENBdEZBLEFBc0ZDLElBQUE7QUF0RlksZ0RBQXdDLDJDQXNGcEQsQ0FBQSIsImZpbGUiOiJhcHAvZ3VpZGVsaW5lLnN0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMvc3RhdGljLWV2YWx1YXRpb24tcmVzdWx0cy5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudCwgT25Jbml0LCBWaWV3Q2hpbGR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuaW1wb3J0IHtFdmFsdWF0aW9uUmVzdWx0fSBmcm9tIFwiLi4vZ3VpZGVsaW5lLnZpZXcvZ3VpZGVsaW5lXCI7XG5pbXBvcnQge09ic2VydmFibGV9IGZyb20gXCJyeGpzXCI7XG5pbXBvcnQge0h0dHB9IGZyb20gXCJAYW5ndWxhci9odHRwXCI7XG5pbXBvcnQge01vZGFsRGlyZWN0aXZlfSBmcm9tIFwibmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL21vZGFsL21vZGFsLmNvbXBvbmVudFwiO1xuaW1wb3J0IHsgVmlld0NvbnRhaW5lclJlZiB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuaW1wb3J0IHsgQ29tcG9uZW50c0hlbHBlciB9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy91dGlscy9jb21wb25lbnRzLWhlbHBlci5zZXJ2aWNlJztcbmltcG9ydCB7SW5wdXR9IGZyb20gXCJAYW5ndWxhci9jb3JlL3NyYy9tZXRhZGF0YS9kaXJlY3RpdmVzXCI7XG5cbkBDb21wb25lbnQoe1xuICBtb2R1bGVJZDogbW9kdWxlLmlkLFxuICBzZWxlY3RvcjogJ3N0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMnLFxuICB0ZW1wbGF0ZVVybDogJ3N0YXRpYy1ldmFsdWF0aW9uLXJlc3VsdHMuY29tcG9uZW50Lmh0bWwnLFxuICBwcm92aWRlcnM6IFtdLFxuICBwaXBlczogW11cbn0pXG5leHBvcnQgY2xhc3MgR3VpZGVsaW5lU3RhdGljRXZhbHVhdGlvblJlc3VsdENvbXBvbmVudCBpbXBsZW1lbnRzIE9uSW5pdCB7XG5cbiAgcHVibGljIHJlc3VsdHM6QXJyYXk8RXZhbHVhdGlvblJlc3VsdD4gPSBuZXcgQXJyYXk8RXZhbHVhdGlvblJlc3VsdD4oKTtcblxuICBAVmlld0NoaWxkKCdjaGlsZE1vZGFsJykgcHVibGljIGNoaWxkTW9kYWw6TW9kYWxEaXJlY3RpdmU7XG5cbiAgcHVibGljIGFjdGl2ZVJlc3VsdDpFdmFsdWF0aW9uUmVzdWx0ID0gbmV3IEV2YWx1YXRpb25SZXN1bHQoKTtcblxuICBwdWJsaWMgc3VtbWFyeTphbnlbXSA9IFtdO1xuXG4gIGNvbnN0cnVjdG9yKHByaXZhdGUgaHR0cDpIdHRwLCBwcml2YXRlIGNvbXBvbmVudHNIZWxwZXI6IENvbXBvbmVudHNIZWxwZXIsIHByaXZhdGUgdmNyOiBWaWV3Q29udGFpbmVyUmVmKSB7XG4gICAgY29tcG9uZW50c0hlbHBlci5zZXRSb290Vmlld0NvbnRhaW5lclJlZih2Y3IpO1xuICB9XG5cbiAgcHVibGljIHNob3dDaGlsZE1vZGFsKGV2ZW50IDogYW55LCByZXN1bHQgOiBFdmFsdWF0aW9uUmVzdWx0KTp2b2lkIHtcbiAgICBldmVudC5wcmV2ZW50RGVmYXVsdCgpO1xuICAgIGNvbnNvbGUubG9nKFwiYWFcIik7XG4gICAgY29uc29sZS5sb2coZXZlbnQpO1xuICAgIGNvbnNvbGUubG9nKHJlc3VsdCk7XG4gICAgdGhpcy5hY3RpdmVSZXN1bHQgPSByZXN1bHQ7XG4gICAgdGhpcy5jaGlsZE1vZGFsLnNob3coKTtcbiAgfVxuXG4gIHB1YmxpYyBoaWRlQ2hpbGRNb2RhbCgpOnZvaWQge1xuICAgIHRoaXMuY2hpbGRNb2RhbC5oaWRlKCk7XG4gIH1cblxuICAvLyBuZ09uSW5pdCgpOiB2b2lkIHtcbiAgLy8gIGZvciAodmFyIGkgPSAwOyBpIDwgMjsgaSsrKSB7XG4gIC8vICAgICBsZXQgZ3VpZGVsaW5lOkV2YWx1YXRpb25SZXN1bHQgPSBuZXcgRXZhbHVhdGlvblJlc3VsdCgpO1xuICAvLyAgICAgZ3VpZGVsaW5lLm5hbWUgPSBcIjc6MiBEaWZmZXJlbnRpYXRlIGFuZCBHcm91cCBOYXZpZ2F0aW9uIEVsZW1lbnRzXCI7XG4gIC8vICAgICBndWlkZWxpbmUuZGVzY3JpcHRpb24gPSBcIkNsZWFybHkgZGlmZmVyZW50aWF0ZSBuYXZpZ2F0aW9uIGVsZW1lbnRzIGZyb20gb25lIGFub3RoZXIsIGJ1dCBncm91cCBhbmQgcGxhY2UgdGhlbSBpbiBhIGNvbnNpc3RlbnQgYW5kIGVhc3kgdG8gZmluZCBwbGFjZSBvbiBlYWNoIHBhZ2UuXCI7XG4gIC8vICAgICB0aGlzLnJlc3VsdHMucHVzaChndWlkZWxpbmUpO1xuICAvLyAgfVxuICAvLyB9XG5cbiAgbmdPbkluaXQoKTogdm9pZCB7XG4gICAgdGhpcy5nZXQoKS5zdWJzY3JpYmUocmVzdWx0cyA9PiB7XG4gICAgICB0aGlzLnJlc3VsdHMgPSByZXN1bHRzO1xuICAgICAgdGhpcy5zdW1tYXJ5ID0gdGhpcy5jYWxjdWxhdGVTdW1tYXJ5KHRoaXMucmVzdWx0cyk7XG4gICAgfSlcbiAgICAvLyBmb3IgKHZhciBpID0gMDsgaSA8IDI7IGkrKykge1xuICAgIC8vICAgIGxldCBndWlkZWxpbmU6R3VpZGVsaW5lID0gbmV3IEd1aWRlbGluZSgpO1xuICAgIC8vICAgIGd1aWRlbGluZS5uYW1lID0gXCI3OjIgRGlmZmVyZW50aWF0ZSBhbmQgR3JvdXAgTmF2aWdhdGlvbiBFbGVtZW50c1wiO1xuICAgIC8vICAgIGd1aWRlbGluZS5kZXNjcmlwdGlvbiA9IFwiQ2xlYXJseSBkaWZmZXJlbnRpYXRlIG5hdmlnYXRpb24gZWxlbWVudHMgZnJvbSBvbmUgYW5vdGhlciwgYnV0IGdyb3VwIGFuZCBwbGFjZSB0aGVtIGluIGEgY29uc2lzdGVudCBhbmQgZWFzeSB0byBmaW5kIHBsYWNlIG9uIGVhY2ggcGFnZS5cIjtcbiAgICAvLyAgICB0aGlzLmd1aWRlbGluZXMucHVzaChndWlkZWxpbmUpO1xuICAgIC8vIH1cbiAgfVxuXG4gIGdldCgpOk9ic2VydmFibGU8YW55PiB7XG4gICAgbGV0IHVybDpzdHJpbmcgPSBgaHR0cDovL2xvY2FsaG9zdDo4MDgwL3Jlc3VsdHNgO1xuICAgIHJldHVybiB0aGlzLmh0dHAuZ2V0KHVybCkubWFwKHJlc3AgPT4gcmVzcC5qc29uKCkpO1xuICB9XG5cbiAgZ2V0Q2xhc3NGb3JQYW5lbChyZXN1bHQgOiBTdHJpbmcpOlN0cmluZyB7XG4gICAgbGV0IGNsYXp6OlN0cmluZyA9IFwic3VjY2Vzc1wiO1xuICAgIGlmIChyZXN1bHQgPT0gXCJGQUlMXCIpIGNsYXp6ID0gXCJkYW5nZXJcIjtcbiAgICByZXR1cm4gXCJwYW5lbCBwYW5lbC1cIiArIGNsYXp6O1xuICB9XG5cbiAgZ2V0Q2xhc3NGb3JMYWJlbChyZXN1bHQgOiBTdHJpbmcpOlN0cmluZyB7XG4gICAgbGV0IGNsYXp6OlN0cmluZyA9IFwic3VjY2Vzc1wiO1xuICAgIGlmIChyZXN1bHQgPT0gXCJGQUlMXCIpIGNsYXp6ID0gXCJkYW5nZXJcIjtcbiAgICByZXR1cm4gXCJsYWJlbCBsYWJlbC1cIiArIGNsYXp6O1xuICB9XG5cbiAgcHJpdmF0ZSBjYWxjdWxhdGVTdW1tYXJ5KHJlc3VsdHM6IEFycmF5PEV2YWx1YXRpb25SZXN1bHQ+KSA6IGFueVtdIHtcbiAgICBsZXQgYW1vdW50T2ZGYWlsZWQgOiBudW1iZXIgPSAwXG4gICAgbGV0IGFtb3VudE9mU3VjY2VzcyA6IG51bWJlciA9IDA7XG4gICAgYW1vdW50T2ZGYWlsZWQgPSByZXN1bHRzLmZpbHRlcihyZXMgPT4gcmVzLnJlc3VsdCA9PSBcIkZBSUxcIikubGVuZ3RoO1xuICAgIGFtb3VudE9mU3VjY2VzcyA9IHJlc3VsdHMuZmlsdGVyKHJlcyA9PiByZXMucmVzdWx0ID09IFwiU1VDQ0VTU1wiKS5sZW5ndGg7XG5cbiAgICB0aGlzLnN1bW1hcnkgPSBbXTtcbiAgICB0aGlzLnN1bW1hcnkucHVzaCh7XG4gICAgICB2YWx1ZTogMTAwKmFtb3VudE9mRmFpbGVkLyhhbW91bnRPZkZhaWxlZCArIGFtb3VudE9mU3VjY2VzcyksXG4gICAgICB0eXBlOiAnZGFuZ2VyJ1xuICAgIH0pO1xuXG4gICAgdGhpcy5zdW1tYXJ5LnB1c2goe1xuICAgICAgdmFsdWU6IDEwMCphbW91bnRPZlN1Y2Nlc3MvKGFtb3VudE9mRmFpbGVkICsgYW1vdW50T2ZTdWNjZXNzKSxcbiAgICAgIHR5cGU6ICdzdWNjZXNzJ1xuICAgIH0pO1xuXG4gICAgcmV0dXJuIHRoaXMuc3VtbWFyeTtcbiAgfVxuXG59XG4iXX0=
