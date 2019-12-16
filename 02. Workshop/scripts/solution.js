function solve() {

    $(`#added-courses`).empty();
    let finalCost= calculateCoursesPrice();
    let finalOnlineOnsiteDiscount = calculateOnlineOnsiteDiscount();
    let numberOfCoursesBonus = calculateNumberOfCoursesBonus();
   
        if(typeof finalOnlineOnsiteDiscount  == "number" && typeof numberOfCoursesBonus == "number") {
            if(numberOfCoursesBonus == 6) {
                finalCost = finalCost - (finalCost * (finalOnlineOnsiteDiscount + numberOfCoursesBonus) / 100);
                $(`#bonus-course`).html(`Bonus course: No`);
            } else {
                finalCost = finalCost - ((finalCost * finalOnlineOnsiteDiscount) / 100 + numberOfCoursesBonus);
                $(`#bonus-course`).html(`Bonus course: No`);
            }
           
        } else {
            finalCost = finalCost - (finalCost * finalOnlineOnsiteDiscount) / 100;
            $(`#bonus-course`).html(numberOfCoursesBonus);
        }

        $(`#final-cost`).html(`Cost: ${finalCost.toFixed(2)} BGN`);

}


function calculateCoursesPrice() {
    let cost = 0;
    for(element of $(`.checkbox`)) {
        if(element.checked) {
           cost+= +element.value;
        }
    }
    return cost;
}


function calculateOnlineOnsiteDiscount() {
    let discount = +0;

    for(element of $(`.radio input`)) {
        if(element.value == `on-line` && element.checked) {
            discount+=6; 
        }
    }
    return discount;
}

function calculateNumberOfCoursesBonus() {
    let bonus = +0;

    let allCourses = Array.from($(`.checkbox`));
    let javaFundamentals = allCourses[0].checked;
    let javaAdvanced = allCourses[1].checked;
    let javaDb = allCourses[2].checked;
    let javaWeb = allCourses[3].checked;

    if(javaFundamentals && javaAdvanced && javaDb && javaWeb) {
        bonus = "Free HTML & CSS course";
    } else if(javaFundamentals && javaAdvanced && javaDb) {
        bonus = 6;
    } else if(javaFundamentals && javaAdvanced) {
        bonus = 17;
    }
    addCourses();
    return bonus;
}


function addCourses() {
    Array.from($(`.checkbox`)).forEach(element => {
        if(element.checked) {
            $(`#added-courses`).append(`<li>${element.parentNode.textContent}</li>`);
        }
       
    })
}