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
    EvaluationResultItemComponent.prototype.showChildModal = function (event, result) {
        console.log("aaaaaaaaa");
        event.preventDefault();
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

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvZXZhbHVhdGlvbi1yZXN1bHQtaXRlbS9ldmFsdWF0aW9uLXJlc3VsdC1pdGVtLmNvbXBvbmVudC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQWtELGVBQWUsQ0FBQyxDQUFBO0FBQ2xFLGdDQUE2QixnREFBZ0QsQ0FBQyxDQUFBO0FBQzlFLDBCQUErQixnQ0FBZ0MsQ0FBQyxDQUFBO0FBRWhFLHFCQUFtQixlQUFlLENBQUMsQ0FBQTtBQUNuQyxxQkFBaUMsZUFBZSxDQUFDLENBQUE7QUFDakQsMENBQWlDLDBEQUEwRCxDQUFDLENBQUE7QUFDNUYsa0NBQStCLDZCQUE2QixDQUFDLENBQUE7QUFVN0Q7SUFPRSx1Q0FBb0IsSUFBUyxFQUFVLGdCQUFrQyxFQUFVLEdBQXFCLEVBQVUsZ0JBQWlDO1FBQS9ILFNBQUksR0FBSixJQUFJLENBQUs7UUFBVSxxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQWtCO1FBQVUsUUFBRyxHQUFILEdBQUcsQ0FBa0I7UUFBVSxxQkFBZ0IsR0FBaEIsZ0JBQWdCLENBQWlCO1FBQ2pKLGdCQUFnQixDQUFDLHVCQUF1QixDQUFDLEdBQUcsQ0FBQyxDQUFDO0lBQ2hELENBQUM7SUFFRCxnREFBUSxHQUFSO0lBRUEsQ0FBQztJQUVNLHNEQUFjLEdBQXJCLFVBQXNCLEtBQVUsRUFBRSxNQUF5QjtRQUN6RCxPQUFPLENBQUMsR0FBRyxDQUFDLFdBQVcsQ0FBQyxDQUFDO1FBQ3pCLEtBQUssQ0FBQyxjQUFjLEVBQUUsQ0FBQztRQUN2QixPQUFPLENBQUMsR0FBRyxDQUFDLE1BQU0sQ0FBQyxDQUFDO1FBQ3BCLElBQUksQ0FBQyxVQUFVLENBQUMsSUFBSSxFQUFFLENBQUM7SUFDekIsQ0FBQztJQUVNLHNEQUFjLEdBQXJCO1FBQ0UsSUFBSSxDQUFDLFVBQVUsQ0FBQyxJQUFJLEVBQUUsQ0FBQztJQUN6QixDQUFDO0lBRUQsd0RBQWdCLEdBQWhCLFVBQWlCLE1BQWU7UUFDOUIsSUFBSSxLQUFLLEdBQVUsU0FBUyxDQUFDO1FBQzdCLEVBQUUsQ0FBQyxDQUFDLE1BQU0sSUFBSSxNQUFNLENBQUM7WUFBQyxLQUFLLEdBQUcsUUFBUSxDQUFDO1FBQ3ZDLE1BQU0sQ0FBQyxjQUFjLEdBQUcsS0FBSyxDQUFDO0lBQ2hDLENBQUM7SUFFRCx3REFBZ0IsR0FBaEIsVUFBaUIsTUFBZTtRQUM5QixJQUFJLEtBQUssR0FBVSxTQUFTLENBQUM7UUFDN0IsRUFBRSxDQUFDLENBQUMsTUFBTSxJQUFJLE1BQU0sQ0FBQztZQUFDLEtBQUssR0FBRyxRQUFRLENBQUM7UUFDdkMsTUFBTSxDQUFDLGNBQWMsR0FBRyxLQUFLLENBQUM7SUFDaEMsQ0FBQztJQWxDRDtRQUFDLFlBQUssRUFBRTs7aUVBQUE7SUFHUjtRQUFDLGdCQUFTLENBQUMsWUFBWSxDQUFDOztxRUFBQTtJQVoxQjtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsTUFBTSxDQUFDLEVBQUU7WUFDbkIsUUFBUSxFQUFFLHdCQUF3QjtZQUNsQyxXQUFXLEVBQUUsdUNBQXVDO1lBQ3BELFNBQVMsRUFBRSxFQUFFO1lBQ2IsS0FBSyxFQUFFLEVBQUU7U0FDVixDQUFDOztxQ0FBQTtJQXNDRixvQ0FBQztBQUFELENBckNBLEFBcUNDLElBQUE7QUFyQ1kscUNBQTZCLGdDQXFDekMsQ0FBQSIsImZpbGUiOiJhcHAvZ3VpZGVsaW5lL2V2YWx1YXRpb24tcmVzdWx0LWl0ZW0vZXZhbHVhdGlvbi1yZXN1bHQtaXRlbS5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudCwgT25Jbml0LCBWaWV3Q2hpbGQsIElucHV0fSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7TW9kYWxEaXJlY3RpdmV9IGZyb20gXCJuZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvbW9kYWwvbW9kYWwuY29tcG9uZW50XCI7XG5pbXBvcnQge0V2YWx1YXRpb25SZXN1bHR9IGZyb20gXCIuLi8uLi9ndWlkZWxpbmUudmlldy9ndWlkZWxpbmVcIjtcbmltcG9ydCB7T2JzZXJ2YWJsZX0gZnJvbSBcInJ4anNcIjtcbmltcG9ydCB7SHR0cH0gZnJvbSBcIkBhbmd1bGFyL2h0dHBcIjtcbmltcG9ydCB7IFZpZXdDb250YWluZXJSZWYgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IENvbXBvbmVudHNIZWxwZXIgfSBmcm9tICduZzItYm9vdHN0cmFwL2NvbXBvbmVudHMvdXRpbHMvY29tcG9uZW50cy1oZWxwZXIuc2VydmljZSc7XG5pbXBvcnQge1VzYWJpbGl0eVNlcnZpY2V9IGZyb20gXCIuLi9zaGFyZWQvdXNhYmlsaXR5LnNlcnZpY2VcIjtcbmltcG9ydCB7Q2F0ZWdvcnlFdmFsdWF0aW9ufSBmcm9tIFwiLi4vLi4vc2hhcmVkL2V2YWx1YXRpb24uZHRvXCI7XG5cbkBDb21wb25lbnQoe1xuICBtb2R1bGVJZDogbW9kdWxlLmlkLFxuICBzZWxlY3RvcjogJ2V2YWx1YXRpb24tcmVzdWx0LWl0ZW0nLFxuICB0ZW1wbGF0ZVVybDogJ2V2YWx1YXRpb24tcmVzdWx0LWl0ZW0uY29tcG9uZW50Lmh0bWwnLFxuICBwcm92aWRlcnM6IFtdLFxuICBwaXBlczogW11cbn0pXG5leHBvcnQgY2xhc3MgRXZhbHVhdGlvblJlc3VsdEl0ZW1Db21wb25lbnQgaW1wbGVtZW50cyBPbkluaXQge1xuXG4gIEBJbnB1dCgpXG4gIHJlc3VsdDogRXZhbHVhdGlvblJlc3VsdDtcblxuICBAVmlld0NoaWxkKCdjaGlsZE1vZGFsJykgcHVibGljIGNoaWxkTW9kYWw6TW9kYWxEaXJlY3RpdmU7XG5cbiAgY29uc3RydWN0b3IocHJpdmF0ZSBodHRwOkh0dHAsIHByaXZhdGUgY29tcG9uZW50c0hlbHBlcjogQ29tcG9uZW50c0hlbHBlciwgcHJpdmF0ZSB2Y3I6IFZpZXdDb250YWluZXJSZWYsIHByaXZhdGUgdXNhYmlsaXR5U2VydmljZTpVc2FiaWxpdHlTZXJ2aWNlKSB7XG4gICAgY29tcG9uZW50c0hlbHBlci5zZXRSb290Vmlld0NvbnRhaW5lclJlZih2Y3IpO1xuICB9XG5cbiAgbmdPbkluaXQoKTogdm9pZCB7XG5cbiAgfVxuXG4gIHB1YmxpYyBzaG93Q2hpbGRNb2RhbChldmVudDogYW55LCByZXN1bHQgOiBFdmFsdWF0aW9uUmVzdWx0KTp2b2lkIHtcbiAgICBjb25zb2xlLmxvZyhcImFhYWFhYWFhYVwiKTtcbiAgICBldmVudC5wcmV2ZW50RGVmYXVsdCgpO1xuICAgIGNvbnNvbGUubG9nKHJlc3VsdCk7XG4gICAgdGhpcy5jaGlsZE1vZGFsLnNob3coKTtcbiAgfVxuXG4gIHB1YmxpYyBoaWRlQ2hpbGRNb2RhbCgpOnZvaWQge1xuICAgIHRoaXMuY2hpbGRNb2RhbC5oaWRlKCk7XG4gIH1cblxuICBnZXRDbGFzc0ZvclBhbmVsKHJlc3VsdCA6IFN0cmluZyk6U3RyaW5nIHtcbiAgICBsZXQgY2xheno6U3RyaW5nID0gXCJzdWNjZXNzXCI7XG4gICAgaWYgKHJlc3VsdCA9PSBcIkZBSUxcIikgY2xhenogPSBcImRhbmdlclwiO1xuICAgIHJldHVybiBcInBhbmVsIHBhbmVsLVwiICsgY2xheno7XG4gIH1cblxuICBnZXRDbGFzc0ZvckxhYmVsKHJlc3VsdCA6IFN0cmluZyk6U3RyaW5nIHtcbiAgICBsZXQgY2xheno6U3RyaW5nID0gXCJzdWNjZXNzXCI7XG4gICAgaWYgKHJlc3VsdCA9PSBcIkZBSUxcIikgY2xhenogPSBcImRhbmdlclwiO1xuICAgIHJldHVybiBcImxhYmVsIGxhYmVsLVwiICsgY2xheno7XG4gIH1cbn1cbiJdfQ==
