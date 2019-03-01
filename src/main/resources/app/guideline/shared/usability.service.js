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
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var UsabilityService = (function () {
    function UsabilityService(http) {
        this.http = http;
    }
    UsabilityService.prototype.evaluateByCategory = function (category, url) {
        var params = new http_1.URLSearchParams();
        params.set('url', url);
        var url = UsabilityService.USABILITY_REST_URL + "/usability/evaluation/" + category;
        return this.http.get(url, { search: params }).map(function (resp) { return resp.json(); });
    };
    UsabilityService.prototype.getUsabilityCategory = function () {
        var url = UsabilityService.USABILITY_REST_URL + "/usability/categories";
        return this.http.get(url).map(function (resp) { return resp.json(); });
    };
    UsabilityService.prototype.getUsabilityGuidelinesByCategory = function (category) {
        var url = (UsabilityService.USABILITY_REST_URL + "/usability/categories/") + category;
        return this.http.get(url).map(function (resp) { return resp.json(); });
    };
    UsabilityService.USABILITY_REST_URL = "http://localhost:8080";
    UsabilityService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], UsabilityService);
    return UsabilityService;
}());
exports.UsabilityService = UsabilityService;

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9ndWlkZWxpbmUvc2hhcmVkL3VzYWJpbGl0eS5zZXJ2aWNlLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQSxxQkFBeUIsZUFBZSxDQUFDLENBQUE7QUFDekMscUJBQW9DLGVBQWUsQ0FBQyxDQUFBO0FBSXBEO0lBSUUsMEJBQW9CLElBQVM7UUFBVCxTQUFJLEdBQUosSUFBSSxDQUFLO0lBQzdCLENBQUM7SUFFRCw2Q0FBa0IsR0FBbEIsVUFBbUIsUUFBZSxFQUFFLEdBQVU7UUFDNUMsSUFBSSxNQUFNLEdBQW9CLElBQUksc0JBQWUsRUFBRSxDQUFDO1FBQ3BELE1BQU0sQ0FBQyxHQUFHLENBQUMsS0FBSyxFQUFFLEdBQUcsQ0FBQyxDQUFDO1FBRXZCLElBQUksR0FBRyxHQUFhLGdCQUFnQixDQUFDLGtCQUFrQiw4QkFBeUIsUUFBVSxDQUFDO1FBRTNGLE1BQU0sQ0FBQyxJQUFJLENBQUMsSUFBSSxDQUFDLEdBQUcsQ0FBQyxHQUFHLEVBQUUsRUFBQyxNQUFNLEVBQUUsTUFBTSxFQUFDLENBQUMsQ0FBQyxHQUFHLENBQUMsVUFBQSxJQUFJLElBQUksT0FBQSxJQUFJLENBQUMsSUFBSSxFQUFFLEVBQVgsQ0FBVyxDQUFDLENBQUM7SUFDdkUsQ0FBQztJQUVELCtDQUFvQixHQUFwQjtRQUNFLElBQUksR0FBRyxHQUFhLGdCQUFnQixDQUFDLGtCQUFrQiwwQkFBdUIsQ0FBQztRQUMvRSxNQUFNLENBQUMsSUFBSSxDQUFDLElBQUksQ0FBQyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUMsR0FBRyxDQUFDLFVBQUEsSUFBSSxJQUFJLE9BQUEsSUFBSSxDQUFDLElBQUksRUFBRSxFQUFYLENBQVcsQ0FBQyxDQUFDO0lBQ3JELENBQUM7SUFFRCwyREFBZ0MsR0FBaEMsVUFBaUMsUUFBZTtRQUM5QyxJQUFJLEdBQUcsR0FBVSxDQUFHLGdCQUFnQixDQUFDLGtCQUFrQiw0QkFBd0IsR0FBRyxRQUFRLENBQUM7UUFDM0YsTUFBTSxDQUFDLElBQUksQ0FBQyxJQUFJLENBQUMsR0FBRyxDQUFDLEdBQUcsQ0FBQyxDQUFDLEdBQUcsQ0FBQyxVQUFBLElBQUksSUFBSSxPQUFBLElBQUksQ0FBQyxJQUFJLEVBQUUsRUFBWCxDQUFXLENBQUMsQ0FBQztJQUNyRCxDQUFDO0lBdEJjLG1DQUFrQixHQUFZLHVCQUF1QixDQUFDO0lBSHZFO1FBQUMsaUJBQVUsRUFBRTs7d0JBQUE7SUEyQmIsdUJBQUM7QUFBRCxDQTFCQSxBQTBCQyxJQUFBO0FBMUJZLHdCQUFnQixtQkEwQjVCLENBQUEiLCJmaWxlIjoiYXBwL2d1aWRlbGluZS9zaGFyZWQvdXNhYmlsaXR5LnNlcnZpY2UuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0luamVjdGFibGV9IGZyb20gXCJAYW5ndWxhci9jb3JlXCI7XHJcbmltcG9ydCB7SHR0cCwgVVJMU2VhcmNoUGFyYW1zfSBmcm9tIFwiQGFuZ3VsYXIvaHR0cFwiO1xyXG5pbXBvcnQge09ic2VydmFibGV9IGZyb20gXCJyeGpzXCI7XHJcblxyXG5ASW5qZWN0YWJsZSgpXHJcbmV4cG9ydCBjbGFzcyBVc2FiaWxpdHlTZXJ2aWNlIHtcclxuXHJcbiAgcHJpdmF0ZSBzdGF0aWMgVVNBQklMSVRZX1JFU1RfVVJMIDogc3RyaW5nID0gYGh0dHA6Ly9sb2NhbGhvc3Q6ODA4MGA7XHJcblxyXG4gIGNvbnN0cnVjdG9yKHByaXZhdGUgaHR0cDpIdHRwKSB7XHJcbiAgfVxyXG5cclxuICBldmFsdWF0ZUJ5Q2F0ZWdvcnkoY2F0ZWdvcnk6c3RyaW5nLCB1cmw6c3RyaW5nKTpPYnNlcnZhYmxlPGFueT4ge1xyXG4gICAgbGV0IHBhcmFtczogVVJMU2VhcmNoUGFyYW1zID0gbmV3IFVSTFNlYXJjaFBhcmFtcygpO1xyXG4gICAgcGFyYW1zLnNldCgndXJsJywgdXJsKTtcclxuXHJcbiAgICBsZXQgdXJsOnN0cmluZyA9IGAke1VzYWJpbGl0eVNlcnZpY2UuVVNBQklMSVRZX1JFU1RfVVJMfS91c2FiaWxpdHkvZXZhbHVhdGlvbi8ke2NhdGVnb3J5fWA7XHJcblxyXG4gICAgcmV0dXJuIHRoaXMuaHR0cC5nZXQodXJsLCB7c2VhcmNoOiBwYXJhbXN9KS5tYXAocmVzcCA9PiByZXNwLmpzb24oKSk7XHJcbiAgfVxyXG5cclxuICBnZXRVc2FiaWxpdHlDYXRlZ29yeSgpOk9ic2VydmFibGU8YW55PiB7XHJcbiAgICBsZXQgdXJsOnN0cmluZyA9IGAke1VzYWJpbGl0eVNlcnZpY2UuVVNBQklMSVRZX1JFU1RfVVJMfS91c2FiaWxpdHkvY2F0ZWdvcmllc2A7XHJcbiAgICByZXR1cm4gdGhpcy5odHRwLmdldCh1cmwpLm1hcChyZXNwID0+IHJlc3AuanNvbigpKTtcclxuICB9XHJcblxyXG4gIGdldFVzYWJpbGl0eUd1aWRlbGluZXNCeUNhdGVnb3J5KGNhdGVnb3J5OnN0cmluZyk6T2JzZXJ2YWJsZTxhbnk+IHtcclxuICAgIGxldCB1cmw6c3RyaW5nID0gYCR7VXNhYmlsaXR5U2VydmljZS5VU0FCSUxJVFlfUkVTVF9VUkx9L3VzYWJpbGl0eS9jYXRlZ29yaWVzL2AgKyBjYXRlZ29yeTtcclxuICAgIHJldHVybiB0aGlzLmh0dHAuZ2V0KHVybCkubWFwKHJlc3AgPT4gcmVzcC5qc29uKCkpO1xyXG4gIH1cclxuXHJcbn1cclxuIl19
