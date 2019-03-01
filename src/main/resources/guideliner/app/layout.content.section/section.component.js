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
var section_service_1 = require('./section.service');
var guideline_evaluate_tab_component_1 = require("../layout.content.section.tabs/guideline-evaluate-tab.component");
var guideline_create_tab_component_1 = require("../layout.content.section.tabs/guideline-create-tab.component");
var guideline_select_categories_tab_component_1 = require("../layout.content.section.tabs/guideline-select-categories-tab.component");
var SectionComponent = (function () {
    function SectionComponent(sectionService, componentResolver) {
        this.sectionService = sectionService;
        this.componentResolver = componentResolver;
        this.isExpanded = false;
        this.tabs = new Array();
    }
    SectionComponent.prototype.closeTab = function (tabType) {
        var tab = this.tabs[tabType];
        if (tab) {
            tab.active = false;
            this.tabs[tabType] = undefined;
        }
    };
    SectionComponent.prototype.closeAllTabs = function () {
        for (var tabType in this.tabs) {
            this.closeTab(tabType);
        }
    };
    SectionComponent.prototype.openTab = function (tabType, tabModel) {
        if (!this.isExpanded) {
            this.sectionService.showBothSections();
        }
        if (!this.tabs[tabType]) {
            this.createTab(tabType, tabModel);
        }
        else {
            this.selectTab(tabType, tabModel);
        }
    };
    SectionComponent.prototype.selectTab = function (tabType, tabModel) {
        var tab = this.tabs[tabType];
        tab.model = tabModel;
        if (!tab.active) {
            tab.active = true;
        }
        for (var key in this.tabs) {
            var tab = this.tabs[key];
            if (tabType != key && tab) {
                tab.active = false;
            }
        }
    };
    SectionComponent.prototype.createTab = function (tabType, tabModel) {
        var factory = this.componentResolver.resolveComponentFactory(tabType);
        var componentRef = this.tabsContainer.createComponent(factory);
        var tab = componentRef.instance;
        tab.ref = componentRef;
        tab.tabType = tabType;
        tab.section = this;
        tab.model = tabModel;
        this.tabs[tabType] = tab;
        this.selectTab(tabType, tabModel);
    };
    SectionComponent.prototype.openGuidelineAutoEvaluationResultsTab = function (categoryEvaluation) {
        this.openTab(guideline_evaluate_tab_component_1.GuidelineEvaluateTab, categoryEvaluation);
    };
    SectionComponent.prototype.openCreateGuidelineTab = function (s) {
        this.openTab(guideline_create_tab_component_1.CreateGuidelineTab, s);
    };
    SectionComponent.prototype.openGuidelineSelectCategoriesTab = function (s) {
        this.openTab(guideline_select_categories_tab_component_1.GuidelineSelectCategoriesTab, s);
    };
    __decorate([
        core_1.ViewChild('tabsContainer', { read: core_1.ViewContainerRef }), 
        __metadata('design:type', core_1.ViewContainerRef)
    ], SectionComponent.prototype, "tabsContainer", void 0);
    SectionComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'kn-section',
            templateUrl: 'section.component.html',
            styleUrls: ['section.component.css']
        }), 
        __metadata('design:paramtypes', [section_service_1.SectionService, core_1.ComponentFactoryResolver])
    ], SectionComponent);
    return SectionComponent;
}());
exports.SectionComponent = SectionComponent;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uL3NlY3Rpb24uY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFLTyxlQUFlLENBQUMsQ0FBQTtBQUN2QixnQ0FBNkIsbUJBQW1CLENBQUMsQ0FBQTtBQUtqRCxpREFBbUMsaUVBQWlFLENBQUMsQ0FBQTtBQUNyRywrQ0FBaUMsK0RBQStELENBQUMsQ0FBQTtBQUNqRywwREFBMkMsMEVBQTBFLENBQUMsQ0FBQTtBQVN0SDtJQU1FLDBCQUFvQixjQUE2QixFQUM3QixpQkFBMEM7UUFEMUMsbUJBQWMsR0FBZCxjQUFjLENBQWU7UUFDN0Isc0JBQWlCLEdBQWpCLGlCQUFpQixDQUF5QjtRQUx2RCxlQUFVLEdBQVcsS0FBSyxDQUFDO1FBRTFCLFNBQUksR0FBRyxJQUFJLEtBQUssRUFBRSxDQUFDO0lBSTNCLENBQUM7SUFFTSxtQ0FBUSxHQUFmLFVBQWdCLE9BQVc7UUFDekIsSUFBSSxHQUFHLEdBQUcsSUFBSSxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUMsQ0FBQztRQUM3QixFQUFFLENBQUMsQ0FBQyxHQUFHLENBQUMsQ0FBQyxDQUFDO1lBQ1IsR0FBRyxDQUFDLE1BQU0sR0FBRyxLQUFLLENBQUM7WUFFbkIsSUFBSSxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUMsR0FBRyxTQUFTLENBQUM7UUFDakMsQ0FBQztJQUNILENBQUM7SUFFTSx1Q0FBWSxHQUFuQjtRQUNFLEdBQUcsQ0FBQyxDQUFDLElBQUksT0FBTyxJQUFJLElBQUksQ0FBQyxJQUFJLENBQUMsQ0FBQyxDQUFDO1lBQzlCLElBQUksQ0FBQyxRQUFRLENBQUMsT0FBTyxDQUFDLENBQUM7UUFDekIsQ0FBQztJQUNILENBQUM7SUFFTSxrQ0FBTyxHQUFkLFVBQWUsT0FBVyxFQUFFLFFBQWE7UUFDdkMsRUFBRSxDQUFDLENBQUMsQ0FBQyxJQUFJLENBQUMsVUFBVSxDQUFDLENBQUMsQ0FBQztZQUNyQixJQUFJLENBQUMsY0FBYyxDQUFDLGdCQUFnQixFQUFFLENBQUM7UUFDekMsQ0FBQztRQUNELEVBQUUsQ0FBQyxDQUFDLENBQUMsSUFBSSxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUMsQ0FBQyxDQUFDLENBQUM7WUFDeEIsSUFBSSxDQUFDLFNBQVMsQ0FBQyxPQUFPLEVBQUUsUUFBUSxDQUFDLENBQUM7UUFDcEMsQ0FBQztRQUFDLElBQUksQ0FBQyxDQUFDO1lBQ04sSUFBSSxDQUFDLFNBQVMsQ0FBQyxPQUFPLEVBQUUsUUFBUSxDQUFDLENBQUM7UUFDcEMsQ0FBQztJQUNILENBQUM7SUFFTSxvQ0FBUyxHQUFoQixVQUFpQixPQUFXLEVBQUUsUUFBYTtRQUN6QyxJQUFJLEdBQUcsR0FBRyxJQUFJLENBQUMsSUFBSSxDQUFDLE9BQU8sQ0FBQyxDQUFDO1FBQzdCLEdBQUcsQ0FBQyxLQUFLLEdBQUcsUUFBUSxDQUFDO1FBR3JCLEVBQUUsQ0FBQyxDQUFDLENBQUMsR0FBRyxDQUFDLE1BQU0sQ0FBQyxDQUFDLENBQUM7WUFDaEIsR0FBRyxDQUFDLE1BQU0sR0FBRyxJQUFJLENBQUM7UUFDcEIsQ0FBQztRQUdELEdBQUcsQ0FBQyxDQUFDLElBQUksR0FBRyxJQUFJLElBQUksQ0FBQyxJQUFJLENBQUMsQ0FBQyxDQUFDO1lBQzFCLElBQUksR0FBRyxHQUFHLElBQUksQ0FBQyxJQUFJLENBQUMsR0FBRyxDQUFDLENBQUM7WUFDekIsRUFBRSxDQUFDLENBQUMsT0FBTyxJQUFJLEdBQUcsSUFBSSxHQUFHLENBQUMsQ0FBQyxDQUFDO2dCQUMxQixHQUFHLENBQUMsTUFBTSxHQUFHLEtBQUssQ0FBQztZQUNyQixDQUFDO1FBQ0gsQ0FBQztJQUNILENBQUM7SUFFTyxvQ0FBUyxHQUFqQixVQUFrQixPQUFXLEVBQUUsUUFBYTtRQUMxQyxJQUFJLE9BQU8sR0FBRyxJQUFJLENBQUMsaUJBQWlCLENBQUMsdUJBQXVCLENBQUMsT0FBTyxDQUFDLENBQUM7UUFDdEUsSUFBSSxZQUFZLEdBQUcsSUFBSSxDQUFDLGFBQWEsQ0FBQyxlQUFlLENBQUMsT0FBTyxDQUFDLENBQUM7UUFDL0QsSUFBSSxHQUFHLEdBQThCLFlBQVksQ0FBQyxRQUFRLENBQUM7UUFDM0QsR0FBRyxDQUFDLEdBQUcsR0FBRyxZQUFZLENBQUM7UUFDdkIsR0FBRyxDQUFDLE9BQU8sR0FBRyxPQUFPLENBQUM7UUFDdEIsR0FBRyxDQUFDLE9BQU8sR0FBRyxJQUFJLENBQUM7UUFDbkIsR0FBRyxDQUFDLEtBQUssR0FBRyxRQUFRLENBQUM7UUFFckIsSUFBSSxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUMsR0FBRyxHQUFHLENBQUM7UUFDekIsSUFBSSxDQUFDLFNBQVMsQ0FBQyxPQUFPLEVBQUUsUUFBUSxDQUFDLENBQUM7SUFDcEMsQ0FBQztJQVVNLGdFQUFxQyxHQUE1QyxVQUE2QyxrQkFBc0M7UUFDakYsSUFBSSxDQUFDLE9BQU8sQ0FBQyx1REFBb0IsRUFBRSxrQkFBa0IsQ0FBQyxDQUFDO0lBQ3pELENBQUM7SUFFTSxpREFBc0IsR0FBN0IsVUFBOEIsQ0FBUztRQUNyQyxJQUFJLENBQUMsT0FBTyxDQUFDLG1EQUFrQixFQUFFLENBQUMsQ0FBQyxDQUFDO0lBQ3RDLENBQUM7SUFFTSwyREFBZ0MsR0FBdkMsVUFBd0MsQ0FBUztRQUMvQyxJQUFJLENBQUMsT0FBTyxDQUFDLHdFQUE0QixFQUFFLENBQUMsQ0FBQyxDQUFDO0lBQ2hELENBQUM7SUFsRkQ7UUFBQyxnQkFBUyxDQUFDLGVBQWUsRUFBRSxFQUFDLElBQUksRUFBRSx1QkFBZ0IsRUFBQyxDQUFDOzsyREFBQTtJQVR2RDtRQUFDLGdCQUFTLENBQUM7WUFDVCxRQUFRLEVBQUUsTUFBTSxDQUFDLEVBQUU7WUFDbkIsUUFBUSxFQUFFLFlBQVk7WUFDdEIsV0FBVyxFQUFFLHdCQUF3QjtZQUNyQyxTQUFTLEVBQUUsQ0FBQyx1QkFBdUIsQ0FBQztTQUNyQyxDQUFDOzt3QkFBQTtJQXVGRix1QkFBQztBQUFELENBdEZBLEFBc0ZDLElBQUE7QUF0Rlksd0JBQWdCLG1CQXNGNUIsQ0FBQSIsImZpbGUiOiJhcHAvbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi9zZWN0aW9uLmNvbXBvbmVudC5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7XG4gIENvbXBvbmVudCxcbiAgVmlld0NvbnRhaW5lclJlZixcbiAgVmlld0NoaWxkLFxuICBDb21wb25lbnRGYWN0b3J5UmVzb2x2ZXJcbn0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQge1NlY3Rpb25TZXJ2aWNlfSBmcm9tICcuL3NlY3Rpb24uc2VydmljZSc7XG5pbXBvcnQge1Rlc3RUYWJDb21wb25lbnR9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvdGVzdC10YWIuY29tcG9uZW50XCI7XG5pbXBvcnQge1RhYkNvbXBvbmVudH0gZnJvbSBcIi4uL2xheW91dC5jb250ZW50LnNlY3Rpb24udGFicy90YWIuY29tcG9uZW50XCI7XG5pbXBvcnQge05hdmlnYXRpb25HdWlkZWxpbmVUYWJ9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvbmF2aWdhdGlvbi1ndWlkZWxpbmUtdGFiLmNvbXBvbmVudFwiO1xuaW1wb3J0IHtHdWlkZWxpbmVFdmFsdWF0aW9uUmVzdWx0c1RhYn0gZnJvbSBcIi4uL2xheW91dC5jb250ZW50LnNlY3Rpb24udGFicy9zdGF0aWMtZ3VpZGVsaW5lLWV2YWx1YXRpb24tcmVzdWx0LXRhYi5jb21wb25lbnRcIjtcbmltcG9ydCB7R3VpZGVsaW5lRXZhbHVhdGVUYWJ9IGZyb20gXCIuLi9sYXlvdXQuY29udGVudC5zZWN0aW9uLnRhYnMvZ3VpZGVsaW5lLWV2YWx1YXRlLXRhYi5jb21wb25lbnRcIjtcbmltcG9ydCB7Q3JlYXRlR3VpZGVsaW5lVGFifSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi50YWJzL2d1aWRlbGluZS1jcmVhdGUtdGFiLmNvbXBvbmVudFwiO1xuaW1wb3J0IHtHdWlkZWxpbmVTZWxlY3RDYXRlZ29yaWVzVGFifSBmcm9tIFwiLi4vbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi50YWJzL2d1aWRlbGluZS1zZWxlY3QtY2F0ZWdvcmllcy10YWIuY29tcG9uZW50XCI7XG5pbXBvcnQge0NhdGVnb3J5RXZhbHVhdGlvbn0gZnJvbSBcIi4uL3NoYXJlZC9ldmFsdWF0aW9uLmR0b1wiO1xuXG5AQ29tcG9uZW50KHtcbiAgbW9kdWxlSWQ6IG1vZHVsZS5pZCxcbiAgc2VsZWN0b3I6ICdrbi1zZWN0aW9uJyxcbiAgdGVtcGxhdGVVcmw6ICdzZWN0aW9uLmNvbXBvbmVudC5odG1sJyxcbiAgc3R5bGVVcmxzOiBbJ3NlY3Rpb24uY29tcG9uZW50LmNzcyddXG59KVxuZXhwb3J0IGNsYXNzIFNlY3Rpb25Db21wb25lbnQge1xuXG4gIHB1YmxpYyBpc0V4cGFuZGVkOmJvb2xlYW4gPSBmYWxzZTtcbiAgQFZpZXdDaGlsZCgndGFic0NvbnRhaW5lcicsIHtyZWFkOiBWaWV3Q29udGFpbmVyUmVmfSkgdGFic0NvbnRhaW5lcjpWaWV3Q29udGFpbmVyUmVmO1xuICBwcml2YXRlIHRhYnMgPSBuZXcgQXJyYXkoKTtcblxuICBjb25zdHJ1Y3Rvcihwcml2YXRlIHNlY3Rpb25TZXJ2aWNlOlNlY3Rpb25TZXJ2aWNlLFxuICAgICAgICAgICAgICBwcml2YXRlIGNvbXBvbmVudFJlc29sdmVyOkNvbXBvbmVudEZhY3RvcnlSZXNvbHZlcikge1xuICB9XG5cbiAgcHVibGljIGNsb3NlVGFiKHRhYlR5cGU6YW55KSB7XG4gICAgdmFyIHRhYiA9IHRoaXMudGFic1t0YWJUeXBlXTtcbiAgICBpZiAodGFiKSB7XG4gICAgICB0YWIuYWN0aXZlID0gZmFsc2U7XG4gICAgICAvL3RhYi5yZWYuZGVzdHJveSgpO1xuICAgICAgdGhpcy50YWJzW3RhYlR5cGVdID0gdW5kZWZpbmVkO1xuICAgIH1cbiAgfVxuXG4gIHB1YmxpYyBjbG9zZUFsbFRhYnMoKSB7XG4gICAgZm9yICh2YXIgdGFiVHlwZSBpbiB0aGlzLnRhYnMpIHtcbiAgICAgIHRoaXMuY2xvc2VUYWIodGFiVHlwZSk7XG4gICAgfVxuICB9XG5cbiAgcHVibGljIG9wZW5UYWIodGFiVHlwZTphbnksIHRhYk1vZGVsPzphbnkpIHtcbiAgICBpZiAoIXRoaXMuaXNFeHBhbmRlZCkge1xuICAgICAgdGhpcy5zZWN0aW9uU2VydmljZS5zaG93Qm90aFNlY3Rpb25zKCk7XG4gICAgfVxuICAgIGlmICghdGhpcy50YWJzW3RhYlR5cGVdKSB7XG4gICAgICB0aGlzLmNyZWF0ZVRhYih0YWJUeXBlLCB0YWJNb2RlbCk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMuc2VsZWN0VGFiKHRhYlR5cGUsIHRhYk1vZGVsKTtcbiAgICB9XG4gIH1cblxuICBwdWJsaWMgc2VsZWN0VGFiKHRhYlR5cGU6YW55LCB0YWJNb2RlbD86YW55KSB7XG4gICAgdmFyIHRhYiA9IHRoaXMudGFic1t0YWJUeXBlXTtcbiAgICB0YWIubW9kZWwgPSB0YWJNb2RlbDtcblxuICAgIC8vIFNlbGVjdCByZXF1aXJlZCB0YWJcbiAgICBpZiAoIXRhYi5hY3RpdmUpIHtcbiAgICAgIHRhYi5hY3RpdmUgPSB0cnVlO1xuICAgIH1cblxuICAgIC8vIERlc2VsZWN0IGFub3RoZXIgdGFic1xuICAgIGZvciAodmFyIGtleSBpbiB0aGlzLnRhYnMpIHtcbiAgICAgIHZhciB0YWIgPSB0aGlzLnRhYnNba2V5XTtcbiAgICAgIGlmICh0YWJUeXBlICE9IGtleSAmJiB0YWIpIHtcbiAgICAgICAgdGFiLmFjdGl2ZSA9IGZhbHNlO1xuICAgICAgfVxuICAgIH1cbiAgfVxuXG4gIHByaXZhdGUgY3JlYXRlVGFiKHRhYlR5cGU6YW55LCB0YWJNb2RlbD86YW55KSB7XG4gICAgbGV0IGZhY3RvcnkgPSB0aGlzLmNvbXBvbmVudFJlc29sdmVyLnJlc29sdmVDb21wb25lbnRGYWN0b3J5KHRhYlR5cGUpO1xuICAgIGxldCBjb21wb25lbnRSZWYgPSB0aGlzLnRhYnNDb250YWluZXIuY3JlYXRlQ29tcG9uZW50KGZhY3RvcnkpO1xuICAgIGxldCB0YWI6VGFiQ29tcG9uZW50ID0gPFRhYkNvbXBvbmVudD5jb21wb25lbnRSZWYuaW5zdGFuY2U7XG4gICAgdGFiLnJlZiA9IGNvbXBvbmVudFJlZjtcbiAgICB0YWIudGFiVHlwZSA9IHRhYlR5cGU7XG4gICAgdGFiLnNlY3Rpb24gPSB0aGlzO1xuICAgIHRhYi5tb2RlbCA9IHRhYk1vZGVsO1xuXG4gICAgdGhpcy50YWJzW3RhYlR5cGVdID0gdGFiO1xuICAgIHRoaXMuc2VsZWN0VGFiKHRhYlR5cGUsIHRhYk1vZGVsKTtcbiAgfVxuXG4gIC8vIHB1YmxpYyBvcGVuTmF2aWdhdGlvbkd1aWRlbGluZVRhYihjaWQ6U3RyaW5nKSB7XG4gIC8vICAgdGhpcy5vcGVuVGFiKE5hdmlnYXRpb25HdWlkZWxpbmVUYWIsIGNpZCk7XG4gIC8vIH1cblxuICAvLyBwdWJsaWMgb3Blbkd1aWRlbGluZUV2YWx1YXRpb25SZXN1bHRzVGFiKGNpZDpTdHJpbmcpIHtcbiAgLy8gICB0aGlzLm9wZW5UYWIoR3VpZGVsaW5lRXZhbHVhdGlvblJlc3VsdHNUYWIsIGNpZCk7XG4gIC8vIH1cblxuICBwdWJsaWMgb3Blbkd1aWRlbGluZUF1dG9FdmFsdWF0aW9uUmVzdWx0c1RhYihjYXRlZ29yeUV2YWx1YXRpb246IENhdGVnb3J5RXZhbHVhdGlvbikge1xuICAgIHRoaXMub3BlblRhYihHdWlkZWxpbmVFdmFsdWF0ZVRhYiwgY2F0ZWdvcnlFdmFsdWF0aW9uKTtcbiAgfVxuXG4gIHB1YmxpYyBvcGVuQ3JlYXRlR3VpZGVsaW5lVGFiKHM6IHN0cmluZykge1xuICAgIHRoaXMub3BlblRhYihDcmVhdGVHdWlkZWxpbmVUYWIsIHMpO1xuICB9XG5cbiAgcHVibGljIG9wZW5HdWlkZWxpbmVTZWxlY3RDYXRlZ29yaWVzVGFiKHM6IHN0cmluZykge1xuICAgIHRoaXMub3BlblRhYihHdWlkZWxpbmVTZWxlY3RDYXRlZ29yaWVzVGFiLCBzKTtcbiAgfVxufVxuIl19
