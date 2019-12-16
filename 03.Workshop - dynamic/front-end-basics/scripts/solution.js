
const moduleDiscount = 0.06;
const javaFundamentalsPlusJavaAdvancedDiscount = 17;

const allAvailableCourses = [
    {name: 'Java Fundamentals', value: 170},
    {name: 'Java Advanced', value: 180},
    {name: 'Java DB', value: 190},
    {name: 'Java Web', value: 490},
]

                    

function solve() {
    addSelectedCourses();
   let cost = calculateMyCoursesCost();
    $(`#result`).html(`Cost: ` + cost.toFixed(2));

}


function calculateMyCoursesCost() {
    const allCourses = Array.from($(`#my-courses li`))
                            .map(course => course.innerHTML);
    let costCourses = 0;
    let discount = 0;

    if(isTrue(allCourses, [`Java Fundamentals`, `Java Advanced`, `Java DB`, `Java Web`])) {
        addHtmlCssCourse();
        costCourses = calculateCost() - javaFundamentalsPlusJavaAdvancedDiscount;
        discount = +calculateOnlineOnsiteDiscount() + moduleDiscount;
      
    } else if(isTrue(allCourses, [`Java Fundamentals`, `Java Advanced`, `Java DB`])) {
        costCourses = calculateCost();
        discount = +calculateOnlineOnsiteDiscount() + moduleDiscount;
    } else if(isTrue(allCourses, [`Java Fundamentals`, `Java Advanced`])) {
        costCourses = calculateCost() - javaFundamentalsPlusJavaAdvancedDiscount;
        discount = +calculateOnlineOnsiteDiscount();
    } else {
        costCourses = calculateCost();
        discount = +calculateOnlineOnsiteDiscount();
    }

    return costCourses * (1 - discount);
}


function addHtmlCssCourse() {
    $(`#my-courses`).append($(`<li></li>`)
                    .html(`Free HTML and CSS`));
}


function calculateOnlineOnsiteDiscount() {
    return $(`#online-onsite input:checked`).val();
}



function calculateCost() {
    let result = 0;
    Array.from($(`#available-courses input:checked`))
                .forEach(course => {
                    result+= +course.value;
                });
    return result;
}

function isTrue(allCourses, currentCourses){
        let isTrue = true;

        currentCourses.forEach(course => {
            if(!allCourses.includes(course)) {
                isTrue = false;
            }
        })
    return isTrue;
  }



function addSelectedCourses() {
    $(`#my-courses`).empty();
    Array.from($(`#available-courses input:checked`))
          .forEach(course => {
            $(`#my-courses`)
                .append($(`<li></li>`)
                .append(course.name));
          });
}




