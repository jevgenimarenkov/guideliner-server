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
var modal_component_1 = require("ng2-bootstrap/components/modal/modal.component");
var guideline_1 = require("../../guideline.view/guideline");
var http_1 = require("@angular/http");
var core_2 = require('@angular/core');
var components_helper_service_1 = require('ng2-bootstrap/components/utils/components-helper.service');
var usability_service_1 = require("../shared/usability.service");
var EvaluationResultItemComponent = (function () {
    function EvaluationResultItemComponent(http, componentsHelper, vcr, usabilityService) {
        this.http = http;
        this.componentsHelper = componentsHelper;
        this.vcr = vcr;
        this.usabilityService = usabilityService;
        componentsHelper.setRootViewContainerRef(vcr);
    }
    EvaluationResultItemComponent.prototype.ngOnInit = function () {
    };
    EvaluationResultItemComponent.prototype.showChildModal = function (result) {
        console.log(result);
        this.childModal.show();
    };
    EvaluationResultItemComponent.prototype.hideChildModal = function () {
        this.childModal.hide();
    };
    EvaluationResultItemComponent.prototype.getClassForPanel = function (result) {
        var clazz = "success";
        if (result == "FAIL")
            clazz = "danger";
        return "panel panel-" + clazz;
    };
    EvaluationResultItemComponent.prototype.getClassForLabel = function (result) {
        var clazz = "success";
        if (result == "FAIL")
            clazz = "danger";
        return "label label-" + clazz;
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', guideline_1.EvaluationResult)
    ], EvaluationResultItemComponent.prototype, "result", void 0);
    __decorate([
        core_1.ViewChild('childModal'), 
        __metadata('design:type', modal_component_1.ModalDirective)
    ], EvaluationResultItemComponent.prototype, "childModal", void 0);
    EvaluationResultItemComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'evaluation-result-item',
            templateUrl: 'evaluation-result-item.component.html',
            providers: [],
            pipes: []
        }), 
        __metadata('design:paramtypes', [http_1.Http, components_helper_service_1.ComponentsHelper, core_2.ViewContainerRef, usability_service_1.UsabilityService])
    ], EvaluationResultItemComponent);
    return EvaluationResultItemComponent;
}());
exports.EvaluationResultItemComponent = EvaluationResultItemComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvZXZhbHVhdGlvbi1yZXN1bHQtaXRlbS9ldmFsdWF0aW9uLXJlc3VsdC1pdGVtLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQWtELGVBQWUsQ0FBQyxDQUFBO0FBQ2xFLGdDQUE2QixnREFBZ0QsQ0FBQyxDQUFBO0FBQzlFLDBCQUErQixnQ0FBZ0MsQ0FBQyxDQUFBO0FBRWhFLHFCQUFtQixlQUFlLENBQUMsQ0FBQTtBQUNuQyxxQkFBaUMsZUFBZSxDQUFDLENBQUE7QUFDakQsMENBQWlDLDBEQUEwRCxDQUFDLENBQUE7QUFDNUYsa0NBQStCLDZCQUE2QixDQUFDLENBQUE7QUFVN0Q7SUFPRSx1Q0FBb0IsSUFBUyxFQUFVLGdCQUFrQyxFQUFVLEdBQXFCLEVBQVUsZ0JBQWlDO1FBQS9ILFNBQUksR0FBSixJQUFJLENBQUs7UUFBVSxxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQWtCO1FBQVUsUUFBRyxHQUFILEdBQUcsQ0FBa0I7UUFBVSxxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQWlCO1FBQ2pKLGdCQUFnQixDQUFDLHVCQUF1QixDQUFDLEdBQUcsQ0FBQyxDQUFDO0lBQ2hELENBQUM7SUFFRCxnREFBUSxHQUFSO0lBRUEsQ0FBQztJQUVNLHNEQUFjLEdBQXJCLFVBQXNCLE1BQXlCO1FBQzdDLE9BQU8sQ0FBQyxHQUFHLENBQUMsTUFBTSxDQUFDLENBQUM7UUFDcEIsSUFBSSxDQUFDLFVBQVUsQ0FBQyxJQUFJLEVBQUUsQ0FBQztJQUN6QixDQUFDO0lBRU0sc0RBQWMsR0FBckI7UUFDRSxJQUFJLENBQUMsVUFBVSxDQUFDLElBQUksRUFBRSxDQUFDO0lBQ3pCLENBQUM7SUFFRCx3REFBZ0IsR0FBaEIsVUFBaUIsTUFBZTtRQUM5QixJQUFJLEtBQUssR0FBVSxTQUFTLENBQUM7UUFDN0IsRUFBRSxDQUFDLENBQUMsTUFBTSxJQUFJLE1BQU0sQ0FBQztZQUFDLEtBQUssR0FBRyxRQUFRLENBQUM7UUFDdkMsTUFBTSxDQUFDLGNBQWMsR0FBRyxLQUFLLENBQUM7SUFDaEMsQ0FBQztJQUVELHdEQUFnQixHQUFoQixVQUFpQixNQUFlO1FBQzlCLElBQUksS0FBSyxHQUFVLFNBQVMsQ0FBQztRQUM3QixFQUFFLENBQUMsQ0FBQyxNQUFNLElBQUksTUFBTSxDQUFDO1lBQUMsS0FBSyxHQUFHLFFBQVEsQ0FBQztRQUN2QyxNQUFNLENBQUMsY0FBYyxHQUFHLEtBQUssQ0FBQztJQUNoQyxDQUFDO0lBaENEO1FBQUMsWUFBSyxFQUFFOztpRUFBQTtJQUdSO1FBQUMsZ0JBQVMsQ0FBQyxZQUFZLENBQUM7O3FFQUFBO0lBWjFCO1FBQUMsZ0JBQVMsQ0FBQztZQUNULFFBQVEsRUFBRSxNQUFNLENBQUMsRUFBRTtZQUNuQixRQUFRLEVBQUUsd0JBQXdCO1lBQ2xDLFdBQVcsRUFBRSx1Q0FBdUM7WUFDcEQsU0FBUyxFQUFFLEVBQUU7WUFDYixLQUFLLEVBQUUsRUFBRTtTQUNWLENBQUM7O3FDQUFBO0lBb0NGLG9DQUFDO0FBQUQsQ0FuQ0EsQUFtQ0MsSUFBQTtBQW5DWSxxQ0FBNkIsZ0NBbUN6QyxDQUFBIiwiZmlsZSI6ImFwcC9ndWlkZWxpbmUvZXZhbHVhdGlvbi1yZXN1bHQtaXRlbS9ldmFsdWF0aW9uLXJlc3VsdC1pdGVtLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBPbkluaXQsIFZpZXdDaGlsZCwgSW5wdXR9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge01vZGFsRGlyZWN0aXZlfSBmcm9tIFwibmcyLWJvb3RzdHJhcC9jb21wb25lbnRzL21vZGFsL21vZGFsLmNvbXBvbmVudFwiO1xyXG5pbXBvcnQge0V2YWx1YXRpb25SZXN1bHR9IGZyb20gXCIuLi8uLi9ndWlkZWxpbmUudmlldy9ndWlkZWxpbmVcIjtcclxuaW1wb3J0IHtPYnNlcnZhYmxlfSBmcm9tIFwicnhqc1wiO1xyXG5pbXBvcnQge0h0dHB9IGZyb20gXCJAYW5ndWxhci9odHRwXCI7XHJcbmltcG9ydCB7IFZpZXdDb250YWluZXJSZWYgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcclxuaW1wb3J0IHsgQ29tcG9uZW50c0hlbHBlciB9IGZyb20gJ25nMi1ib290c3RyYXAvY29tcG9uZW50cy91dGlscy9jb21wb25lbnRzLWhlbHBlci5zZXJ2aWNlJztcclxuaW1wb3J0IHtVc2FiaWxpdHlTZXJ2aWNlfSBmcm9tIFwiLi4vc2hhcmVkL3VzYWJpbGl0eS5zZXJ2aWNlXCI7XHJcbmltcG9ydCB7Q2F0ZWdvcnlFdmFsdWF0aW9ufSBmcm9tIFwiLi4vLi4vc2hhcmVkL2V2YWx1YXRpb24uZHRvXCI7XHJcblxyXG5AQ29tcG9uZW50KHtcclxuICBtb2R1bGVJZDogbW9kdWxlLmlkLFxyXG4gIHNlbGVjdG9yOiAnZXZhbHVhdGlvbi1yZXN1bHQtaXRlbScsXHJcbiAgdGVtcGxhdGVVcmw6ICdldmFsdWF0aW9uLXJlc3VsdC1pdGVtLmNvbXBvbmVudC5odG1sJyxcclxuICBwcm92aWRlcnM6IFtdLFxyXG4gIHBpcGVzOiBbXVxyXG59KVxyXG5leHBvcnQgY2xhc3MgRXZhbHVhdGlvblJlc3VsdEl0ZW1Db21wb25lbnQgaW1wbGVtZW50cyBPbkluaXQge1xyXG5cclxuICBASW5wdXQoKVxyXG4gIHJlc3VsdDogRXZhbHVhdGlvblJlc3VsdDtcclxuXHJcbiAgQFZpZXdDaGlsZCgnY2hpbGRNb2RhbCcpIHB1YmxpYyBjaGlsZE1vZGFsOk1vZGFsRGlyZWN0aXZlO1xyXG5cclxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIGh0dHA6SHR0cCwgcHJpdmF0ZSBjb21wb25lbnRzSGVscGVyOiBDb21wb25lbnRzSGVscGVyLCBwcml2YXRlIHZjcjogVmlld0NvbnRhaW5lclJlZiwgcHJpdmF0ZSB1c2FiaWxpdHlTZXJ2aWNlOlVzYWJpbGl0eVNlcnZpY2UpIHtcclxuICAgIGNvbXBvbmVudHNIZWxwZXIuc2V0Um9vdFZpZXdDb250YWluZXJSZWYodmNyKTtcclxuICB9XHJcblxyXG4gIG5nT25Jbml0KCk6IHZvaWQge1xyXG5cclxuICB9XHJcblxyXG4gIHB1YmxpYyBzaG93Q2hpbGRNb2RhbChyZXN1bHQgOiBFdmFsdWF0aW9uUmVzdWx0KTp2b2lkIHtcclxuICAgIGNvbnNvbGUubG9nKHJlc3VsdCk7XHJcbiAgICB0aGlzLmNoaWxkTW9kYWwuc2hvdygpO1xyXG4gIH1cclxuXHJcbiAgcHVibGljIGhpZGVDaGlsZE1vZGFsKCk6dm9pZCB7XHJcbiAgICB0aGlzLmNoaWxkTW9kYWwuaGlkZSgpO1xyXG4gIH1cclxuXHJcbiAgZ2V0Q2xhc3NGb3JQYW5lbChyZXN1bHQgOiBTdHJpbmcpOlN0cmluZyB7XHJcbiAgICBsZXQgY2xheno6U3RyaW5nID0gXCJzdWNjZXNzXCI7XHJcbiAgICBpZiAocmVzdWx0ID09IFwiRkFJTFwiKSBjbGF6eiA9IFwiZGFuZ2VyXCI7XHJcbiAgICByZXR1cm4gXCJwYW5lbCBwYW5lbC1cIiArIGNsYXp6O1xyXG4gIH1cclxuXHJcbiAgZ2V0Q2xhc3NGb3JMYWJlbChyZXN1bHQgOiBTdHJpbmcpOlN0cmluZyB7XHJcbiAgICBsZXQgY2xheno6U3RyaW5nID0gXCJzdWNjZXNzXCI7XHJcbiAgICBpZiAocmVzdWx0ID09IFwiRkFJTFwiKSBjbGF6eiA9IFwiZGFuZ2VyXCI7XHJcbiAgICByZXR1cm4gXCJsYWJlbCBsYWJlbC1cIiArIGNsYXp6O1xyXG4gIH1cclxufVxyXG4iXX0=
