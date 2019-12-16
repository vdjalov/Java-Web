const availableCourses = [
    {name: 'Java Fundamentals', value: 170},
    {name: 'Java Advanced', value: 180},
    {name: 'Java DB', value: 190},
    {name: 'Java Web', value: 490},
]

const onlineOnsite = [
    {name: 'Onsite', value: 0.00},
    {name: 'Online', value: 0.06},
   
]


$(function() {
    addCoursesButtons();
    addOnlineDiscountButtons();

    

});

function addOnlineDiscountButtons() {
    let count = 0;
    onlineOnsite.forEach(option => {
        let input = getButton(option.value);
                 if(count === 0) {
                     $(input).attr(`checked`, true);
                     count++;
                 }      
        $(`#online-onsite`).append($(`<li></li>`)
                           .append($(`<label></label>`)
                           .append(input)
                           .append(option.name)));
    });

}

function getButton(value) {
    return $(`<input>`)
                .attr(`type`, `radio`)
                .attr(`name`, `online-onsite-discount`)
                .val(value)
}

function addCoursesButtons() {
    availableCourses.forEach(course => {
        const input = getCourse(course);
                                
        $(`#available-courses`)
           .append($(`<li></li>`)
           .append(input));
    });
}


function getCourse(course) {
    return $(`<label>`).append($(`<input/>`)
                        .attr(`type`, `checkbox`)
                        .attr(`name`, course.name)
                        .val(course.value))
                        .append(course.name);
}



