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
var SectionService = (function () {
    function SectionService() {
    }
    SectionService.prototype.expandLeftSection = function () {
        this.leftSection.isExpanded = true;
        this.rightSection.isExpanded = false;
    };
    SectionService.prototype.expandRightSection = function () {
        this.leftSection.isExpanded = false;
        this.rightSection.isExpanded = true;
    };
    SectionService.prototype.showBothSections = function () {
        this.leftSection.isExpanded = false;
        this.rightSection.isExpanded = false;
    };
    SectionService.prototype.closeAllTabs = function () {
        this.leftSection.closeAllTabs();
        this.rightSection.closeAllTabs();
    };
    SectionService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], SectionService);
    return SectionService;
}());
exports.SectionService = SectionService;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9sYXlvdXQuY29udGVudC5zZWN0aW9uL3NlY3Rpb24uc2VydmljZS50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUEscUJBQXlCLGVBQWUsQ0FBQyxDQUFBO0FBSXpDO0lBQUE7SUF3QkEsQ0FBQztJQW5CVSwwQ0FBaUIsR0FBeEI7UUFDSSxJQUFJLENBQUMsV0FBVyxDQUFDLFVBQVUsR0FBRyxJQUFJLENBQUM7UUFDbkMsSUFBSSxDQUFDLFlBQVksQ0FBQyxVQUFVLEdBQUcsS0FBSyxDQUFDO0lBQ3pDLENBQUM7SUFFTSwyQ0FBa0IsR0FBekI7UUFDSSxJQUFJLENBQUMsV0FBVyxDQUFDLFVBQVUsR0FBRyxLQUFLLENBQUM7UUFDcEMsSUFBSSxDQUFDLFlBQVksQ0FBQyxVQUFVLEdBQUcsSUFBSSxDQUFDO0lBQ3hDLENBQUM7SUFFTSx5Q0FBZ0IsR0FBdkI7UUFDSSxJQUFJLENBQUMsV0FBVyxDQUFDLFVBQVUsR0FBRyxLQUFLLENBQUM7UUFDcEMsSUFBSSxDQUFDLFlBQVksQ0FBQyxVQUFVLEdBQUcsS0FBSyxDQUFDO0lBQ3pDLENBQUM7SUFFTSxxQ0FBWSxHQUFuQjtRQUNJLElBQUksQ0FBQyxXQUFXLENBQUMsWUFBWSxFQUFFLENBQUM7UUFDaEMsSUFBSSxDQUFDLFlBQVksQ0FBQyxZQUFZLEVBQUUsQ0FBQztJQUNyQyxDQUFDO0lBeEJMO1FBQUMsaUJBQVUsRUFBRTs7c0JBQUE7SUF5QmIscUJBQUM7QUFBRCxDQXhCQSxBQXdCQyxJQUFBO0FBeEJZLHNCQUFjLGlCQXdCMUIsQ0FBQSIsImZpbGUiOiJhcHAvbGF5b3V0LmNvbnRlbnQuc2VjdGlvbi9zZWN0aW9uLnNlcnZpY2UuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0luamVjdGFibGV9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xyXG5pbXBvcnQge1NlY3Rpb25Db21wb25lbnR9IGZyb20gJy4vc2VjdGlvbi5jb21wb25lbnQnO1xyXG5cclxuQEluamVjdGFibGUoKVxyXG5leHBvcnQgY2xhc3MgU2VjdGlvblNlcnZpY2Uge1xyXG5cclxuICAgIHB1YmxpYyBsZWZ0U2VjdGlvbjogU2VjdGlvbkNvbXBvbmVudDtcclxuICAgIHB1YmxpYyByaWdodFNlY3Rpb246IFNlY3Rpb25Db21wb25lbnQ7XHJcblxyXG4gICAgcHVibGljIGV4cGFuZExlZnRTZWN0aW9uKCkge1xyXG4gICAgICAgIHRoaXMubGVmdFNlY3Rpb24uaXNFeHBhbmRlZCA9IHRydWU7XHJcbiAgICAgICAgdGhpcy5yaWdodFNlY3Rpb24uaXNFeHBhbmRlZCA9IGZhbHNlO1xyXG4gICAgfVxyXG5cclxuICAgIHB1YmxpYyBleHBhbmRSaWdodFNlY3Rpb24oKSB7XHJcbiAgICAgICAgdGhpcy5sZWZ0U2VjdGlvbi5pc0V4cGFuZGVkID0gZmFsc2U7XHJcbiAgICAgICAgdGhpcy5yaWdodFNlY3Rpb24uaXNFeHBhbmRlZCA9IHRydWU7XHJcbiAgICB9XHJcblxyXG4gICAgcHVibGljIHNob3dCb3RoU2VjdGlvbnMoKSB7XHJcbiAgICAgICAgdGhpcy5sZWZ0U2VjdGlvbi5pc0V4cGFuZGVkID0gZmFsc2U7XHJcbiAgICAgICAgdGhpcy5yaWdodFNlY3Rpb24uaXNFeHBhbmRlZCA9IGZhbHNlO1xyXG4gICAgfVxyXG5cclxuICAgIHB1YmxpYyBjbG9zZUFsbFRhYnMoKSB7XHJcbiAgICAgICAgdGhpcy5sZWZ0U2VjdGlvbi5jbG9zZUFsbFRhYnMoKTtcclxuICAgICAgICB0aGlzLnJpZ2h0U2VjdGlvbi5jbG9zZUFsbFRhYnMoKTtcclxuICAgIH1cclxufVxyXG4iXX0=
